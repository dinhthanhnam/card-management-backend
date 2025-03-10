package com.api.cardmanagementapp.service;

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
}
