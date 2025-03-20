package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.client.create.CreateClientV4;
import com.api.cardmanagementapp.dto.client.create.CreateClientV4Response;
import com.api.cardmanagementapp.dto.client.create.CreateClientV4Result;
import com.api.cardmanagementapp.dto.client.edit.EditClientV6;
import com.api.cardmanagementapp.dto.client.edit.EditClientV6Response;
import com.api.cardmanagementapp.dto.client.edit.EditClientV6Result;
import com.api.cardmanagementapp.dto.common.IssContractDetailsAPIOutputV2Record;
import com.api.cardmanagementapp.dto.contract.get.GetContractsByClientV2;
import com.api.cardmanagementapp.dto.contract.get.GetContractsByClientV2Response;
import com.api.cardmanagementapp.dto.contract.get.GetContractsByClientV2Result;
import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.model.PagedClientResponse;
import com.api.cardmanagementapp.service.ClientService;
import com.api.cardmanagementapp.service.ContractService;
import com.api.cardmanagementapp.service.OracleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final OracleQueryService oracleQueryService;
    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<PagedClientResponse> getAllClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PagedClientResponse response = oracleQueryService.getPagedClientData(page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return oracleQueryService.getClientById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClient(
            @RequestBody CreateClientV4 createClientV4,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        CreateClientV4Response soapResponse = clientService.sendCreateClientRequest(
                createClientV4, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getCreateClientV4Result() != null) {
            CreateClientV4Result result = soapResponse.getCreateClientV4Result();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Client created successfully. NewClient: "
                        + result.getNewClient() + ", ApplicationNumber: " + result.getApplicationNumber());
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error creating client: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editClient(
            @RequestBody EditClientV6 editClientV6,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        EditClientV6Response soapResponse = clientService.sendEditClientRequest(
                editClientV6, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getEditClientV6Result() != null) {
            EditClientV6Result result = soapResponse.getEditClientV6Result();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Client updated successfully");
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error editing client: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    @PostMapping("/contracts")
    public ResponseEntity<List<Contract>> getContracts(
            @RequestBody Client client,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        GetContractsByClientV2 getContractsByClientV2 = new GetContractsByClientV2();
        getContractsByClientV2.setClientIdentifier(client.getClientNumber());
        getContractsByClientV2.setClientSearchMethod("CLIENT_NUMBER");

        GetContractsByClientV2Response soapResponse = contractService.sendGetContractsByClientRequest(
                getContractsByClientV2, sessionContextStr, userInfo, correlationId);

        // Kiểm tra SOAP response
        if (soapResponse == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // 500 nếu SOAP call thất bại
        }

        // Lấy danh sách records, xử lý trường hợp null hoặc rỗng
        List<IssContractDetailsAPIOutputV2Record> records = null;
        try {
            records = soapResponse.getGetContractsByClientV2Result()
                    .getOutObject()
                    .getIssContractDetailsAPIOutputV2Record();
        } catch (NullPointerException e) {
            // Nếu bất kỳ phần nào (Result, OutObject) là null, coi như không có record
        }

        if (records == null || records.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>()); // 200 OK với danh sách rỗng
        }

        // Xây dựng cây hợp đồng
        List<Contract> contracts = buildContractTree(records);
        return ResponseEntity.ok(contracts);
    }

    private List<Contract> buildContractTree(List<IssContractDetailsAPIOutputV2Record> records) {
        Map<String, Contract> contractMap = new HashMap<>();
        List<Contract> rootContracts = new ArrayList<>();

        // Duyệt qua từng record để ánh xạ và xây dựng cây
        for (IssContractDetailsAPIOutputV2Record record : records) {
            String contractNumber = record.getContractNumber();
            String contractName = record.getContractName();
            String contractLevel = record.getContractLevel();

            // Suy luận contractType từ contractName hoặc contractCategory
            String contractType = inferContractType(contractName, record.getContractCategory());

            Contract contract = Contract.builder()
                    .contractNumber(contractNumber)
                    .contractType(contractType)
                    .subContracts(new ArrayList<>())
                    .build();

            contractMap.put(contractNumber, contract);

            // Nếu là cấp 0 (root)
            if (contractLevel.equals(".")) {
                rootContracts.add(contract);
            } else {
                // Tìm parent contract
                String parentContractId = extractParentId(record.getParentContract());
                Contract parentContract = contractMap.get(parentContractId);
                if (parentContract != null) {
                    parentContract.getSubContracts().add(contract);
                }
            }
        }

        return rootContracts;
    }

    private String inferContractType(String contractName, String contractCategory) {
        if (contractName.contains("Liability")) {
            return "Liability";
        } else if (contractName.contains("Issuing")) {
            return "Issuing";
        } else if (contractCategory.startsWith("C;")) { // Card contract
            return "Card";
        }
        return "Unknown"; // Trường hợp không xác định được
    }

    private String extractParentId(String parentContract) {
        if (parentContract != null && parentContract.contains(";")) {
            return parentContract.split(";")[1]; // Lấy phần sau dấu ";"
        }
        return null;
    }
}
