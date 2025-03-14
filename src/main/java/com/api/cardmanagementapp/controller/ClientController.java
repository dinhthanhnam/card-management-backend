package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.client.CreateClientV4;
import com.api.cardmanagementapp.dto.client.CreateClientV4Response;
import com.api.cardmanagementapp.dto.client.CreateClientV4Result;
import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.service.ClientService;
import com.api.cardmanagementapp.service.OracleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final OracleQueryService oracleQueryService;

    @GetMapping
    public List<Client> getAllClients() {
      return oracleQueryService.getClientData();
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
}
