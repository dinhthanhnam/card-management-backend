package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.client.CreateClientV4;
import com.api.cardmanagementapp.dto.client.CreateClientV4Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final WebServiceTemplate webServiceTemplate;

    public CreateClientV4Response sendCreateClientRequest(CreateClientV4 createClientV4) {
        // Gọi SOAP request và ép kiểu kết quả trả về thành CreateClientV4Response
        return (CreateClientV4Response) webServiceTemplate.marshalSendAndReceive(createClientV4);
    }
}
