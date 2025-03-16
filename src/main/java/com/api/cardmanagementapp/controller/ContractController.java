package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.contract.create.CreateContractV4;
import com.api.cardmanagementapp.dto.contract.create.CreateContractV4Response;
import com.api.cardmanagementapp.dto.contract.create.CreateContractV4Result;
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
}