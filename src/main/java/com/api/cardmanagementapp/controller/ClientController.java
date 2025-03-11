package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.client.CreateClientV4;
import com.api.cardmanagementapp.dto.client.CreateClientV4Response;
import com.api.cardmanagementapp.dto.client.CreateClientV4Result;
import com.api.cardmanagementapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody CreateClientV4 createClientV4) {
        // Gửi request và nhận response từ SOAP service
        CreateClientV4Response response = clientService.sendCreateClientRequest(createClientV4);

        // Kiểm tra response hợp lệ và xử lý kết quả
        if (response != null && response.getCreateClientV4Result() != null) {
            CreateClientV4Result result = response.getCreateClientV4Result();

            // Giả sử RetCode "0" nghĩa là thành công
            if ("0".equals(result.getRetCode())) {
                String successMessage = "Client created successfully. NewClient: " + result.getNewClient()
                        + ", ApplicationNumber: " + result.getApplicationNumber();
                return ResponseEntity.ok(successMessage);
            } else {
                String errorMessage = "Error creating client: " + result.getRetMsg();
                return ResponseEntity.badRequest().body(errorMessage);
            }
        }
        return ResponseEntity.status(500).body("Invalid or empty response received from SOAP service.");
    }
}