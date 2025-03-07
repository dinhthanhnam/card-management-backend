package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.CreateClientV4Request;
import com.api.cardmanagementapp.dto.CreateClientV4Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@RequiredArgsConstructor
public class SoapClientService {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    // Endpoint SOAP của bạn
    private final String soapEndpoint = "http://10.145.48.222:17000/webservice_int/ws";

    public CreateClientV4Response callCreateClientV4(CreateClientV4Request request) {
        return (CreateClientV4Response) webServiceTemplate.marshalSendAndReceive(soapEndpoint, request);
    }
}
