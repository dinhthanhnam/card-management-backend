package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.card.CreateCardV3;
import com.api.cardmanagementapp.dto.card.CreateCardV3Response;
import com.api.cardmanagementapp.dto.card.CreateCardV3Result;
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
}
