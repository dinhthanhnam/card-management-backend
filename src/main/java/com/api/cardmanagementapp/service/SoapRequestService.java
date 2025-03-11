package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.client.CreateClientV4;
import com.api.cardmanagementapp.dto.client.CreateClientV4Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@RequiredArgsConstructor
public class SoapRequestService {

    private final WebServiceTemplate webServiceTemplate;

    public CreateClientV4Response sendCreateClientRequest(CreateClientV4 createClientV4) {
        // Gửi request
        CreateClientV4Response response = (CreateClientV4Response) webServiceTemplate.marshalSendAndReceive(createClientV4);
        return response;
    }
}