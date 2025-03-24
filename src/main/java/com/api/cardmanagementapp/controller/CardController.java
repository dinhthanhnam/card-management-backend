package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.card.*;
import com.api.cardmanagementapp.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<?> createCard(@RequestBody CreateCardV3 createCardV3,
                                        @RequestHeader("X-SessionContextStr") String sessionContextStr,
                                        @RequestHeader("X-UserInfo") String userInfo,
                                        @RequestHeader("X-CorrelationId") String correlationId) {
        CreateCardV3Response soapResponse = cardService.sendCreateCardRequest(
                createCardV3, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getCreateCardV3Result() != null) {
            CreateCardV3Result result = soapResponse.getCreateCardV3Result();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Card created successfully. Created Card: "
                        + result.getCreatedCard() + ", CardNumber: " + result.getCardNumber());
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error creating card: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    @PostMapping("/activate")
    public ResponseEntity<?> activateCard(@RequestBody ActivateCard activateCard,
                                        @RequestHeader("X-SessionContextStr") String sessionContextStr,
                                        @RequestHeader("X-UserInfo") String userInfo,
                                        @RequestHeader("X-CorrelationId") String correlationId) {
        ActivateCardResponse soapResponse = cardService.sendActivateCardRequest(
                activateCard, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getActivateCardResult() != null) {
            ActivateCardResult result = soapResponse.getActivateCardResult();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Card activated successfully: "
                        + result.getRetMsg());
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error activating card: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    @PostMapping("/set-status")
    public ResponseEntity<?> setCardStatus(@RequestBody SetCardStatus setCardStatus,
                                          @RequestHeader("X-SessionContextStr") String sessionContextStr,
                                          @RequestHeader("X-UserInfo") String userInfo,
                                          @RequestHeader("X-CorrelationId") String correlationId) {
        SetCardStatusResponse soapResponse = cardService.sendSetCardStatusRequest(
                setCardStatus, sessionContextStr, userInfo, correlationId);

        Map<String, Object> responseBody = new HashMap<>();
        if (soapResponse != null && soapResponse.getSetCardStatusResult() != null) {
            SetCardStatusResult result = soapResponse.getSetCardStatusResult();
            if ("0".equals(result.getRetCode())) {
                responseBody.put("statusCode", HttpStatus.OK.value());
                responseBody.put("success", true);
                responseBody.put("message", "Set card successfully: "
                        + result.getRetMsg());
                responseBody.put("data", result);
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
                responseBody.put("success", false);
                responseBody.put("message", "Error setting card: " + result.getRetMsg());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
        }
        responseBody.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("success", false);
        responseBody.put("message", "Invalid response received from SOAP service.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
