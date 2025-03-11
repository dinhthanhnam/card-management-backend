package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.dto.client.CreateClientV4;
import com.api.cardmanagementapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public String createClient(@RequestBody CreateClientV4 createClientV4) {
        clientService.sendCreateClientRequest(createClientV4);
        return "Request đã được gửi đến WebService";
    }
}