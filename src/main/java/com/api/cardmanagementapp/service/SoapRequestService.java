package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.common.SoapBody;
import com.api.cardmanagementapp.dto.common.SoapEnvelope;
import com.api.cardmanagementapp.dto.common.SoapHeader;
import com.api.cardmanagementapp.dto.client.CreateClientV4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@RequiredArgsConstructor
public class SoapRequestService {

    private final WebServiceTemplate webServiceTemplate;

    public void sendCreateClientRequest(CreateClientV4 createClientV4) {
        // Header cố định
        SoapHeader header = new SoapHeader();
        header.setSessionContextStr("?");
        header.setUserInfo("officer=\"WX_ADMIN\"");
        header.setCorrelationId("?");

        // Body từ JSON
        SoapBody body = new SoapBody();
        body.setCreateClientV4(createClientV4);

        // Envelope
        SoapEnvelope envelope = new SoapEnvelope();
        envelope.setHeader(header);
        envelope.setBody(body);

        // Gửi request
        webServiceTemplate.marshalSendAndReceive(envelope);
    }
}