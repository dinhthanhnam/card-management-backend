package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.client.CreateClientV4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final SoapRequestService soapRequestService;

    public void sendCreateClientRequest(CreateClientV4 createClientV4) {
        soapRequestService.sendCreateClientRequest(createClientV4);
    }
}