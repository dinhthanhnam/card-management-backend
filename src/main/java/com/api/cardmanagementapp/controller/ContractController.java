package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.contract.create.CreateContractV4;
import com.api.cardmanagementapp.dto.contract.create.CreateContractV4Response;
import com.api.cardmanagementapp.dto.contract.create.CreateContractV4Result;
import com.api.cardmanagementapp.dto.contract.edit.EditContractV4;
import com.api.cardmanagementapp.dto.contract.edit.EditContractV4Response;
import com.api.cardmanagementapp.dto.contract.edit.EditContractV4Result;
import com.api.cardmanagementapp.dto.contract.get.*;
import com.api.cardmanagementapp.dto.issuing.CreateIssuingContractWithLiabilityV2;
import com.api.cardmanagementapp.dto.issuing.CreateIssuingContractWithLiabilityV2Response;
import com.api.cardmanagementapp.dto.issuing.CreateIssuingContractWithLiabilityV2Result;
import com.api.cardmanagementapp.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/contracts")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @PostMapping("/create")
    public ResponseEntity<?> createContract(
            @RequestBody CreateContractV4 createContractV4,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        CreateContractV4Response soapResponse = contractService.sendCreateContractRequest(
                createContractV4, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getCreateContractV4Result() != null) {
            CreateContractV4Result result = soapResponse.getCreateContractV4Result();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Contract created successfully. Created Contract: "
                        + result.getCreatedContract() + ", ApplicationNumber: " + result.getApplicationNumber());
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error creating contract: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    @PostMapping("/createIssuingWithLiability")
    public ResponseEntity<?> createIssuingContractWithLiability(
            @RequestBody CreateIssuingContractWithLiabilityV2 createIssuingContractWithLiabilityV2,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        CreateIssuingContractWithLiabilityV2Response soapResponse = contractService.sendCreateIssuingContractWithLiabilityRequest(
                createIssuingContractWithLiabilityV2, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getCreateIssuingContractWithLiabilityV2Result() != null) {
            CreateIssuingContractWithLiabilityV2Result result = soapResponse.getCreateIssuingContractWithLiabilityV2Result()    ;
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Issuing contract created successfully. Created Contract: "
                        + result.getCreatedContract() + ", ApplicationNumber: " + result.getApplicationNumber());
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error creating contract: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    @PostMapping("/getContractByNumber")
    public ResponseEntity<?> getContractByNumber(
            @RequestBody GetContractByNumberV2 getContractByNumberV2,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        GetContractByNumberV2Response soapResponse = contractService.sendGetContractByNumberRequest(
                getContractByNumberV2, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getGetContractByNumberV2Result() != null) {
            GetContractByNumberV2Result result = soapResponse.getGetContractByNumberV2Result();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Get contract by number successfully");
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error getting contract by number: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    @PostMapping("/getContractsByClient")
    public ResponseEntity<?> getContractsByClient(
            @RequestBody GetContractsByClientV2 getContractsByClientV2,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        GetContractsByClientV2Response soapResponse = contractService.sendGetContractsByClientRequest(
                getContractsByClientV2, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getGetContractsByClientV2Result() != null) {
            GetContractsByClientV2Result result = soapResponse.getGetContractsByClientV2Result();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Get contracts by client successfully");
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error getting contracts by client: " + result.getRetMsg());
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
            @RequestBody EditContractV4 editContractV4,
            @RequestHeader("X-SessionContextStr") String sessionContextStr,
            @RequestHeader("X-UserInfo") String userInfo,
            @RequestHeader("X-CorrelationId") String correlationId) {

        EditContractV4Response soapResponse = contractService.sendEditContractRequest(
                editContractV4, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getEditContractV4Result() != null) {
            EditContractV4Result result = soapResponse.getEditContractV4Result();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Contract updated successfully");
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error editing contract: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}