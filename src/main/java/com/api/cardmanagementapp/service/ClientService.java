package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.common.*;
import com.api.cardmanagementapp.dto.client.CreateClientInObject;
import com.api.cardmanagementapp.dto.client.CreateClientV4;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final WebServiceTemplate webServiceTemplate;

    public void sendCreateClientRequest(CreateClientInObject clientInObject) {
        // Tạo SoapHeader bằng builder
        SoapHeader header = SoapHeader.builder()
                .sessionContextStr("?")
                .userInfo("officer=\"WX_ADMIN\"")
                .correlationId("?")
                .build();

        // Tạo SetCustomDataInObject bằng builder
        SetCustomDataInObject customData1 = SetCustomDataInObject.builder()
                .addInfoType("AddInfo01")
                .tagName("PrevID_01")
                .tagValue("A1")
                .build();

        SetCustomDataInObject customData2 = SetCustomDataInObject.builder()
                .addInfoType("AddInfo01")
                .tagName("PrevID_02")
                .tagValue("A2")
                .build();

        // Tạo CreateClientV4 bằng builder
        CreateClientV4 createClientV4 = CreateClientV4.builder()
                .reason("Create client")
                .createClientInObject(clientInObject)
                .setCustomDataInObjects(List.of(customData1, customData2))
                .build();

        // Tạo SoapBody bằng builder
        SoapBody body = SoapBody.builder()
                .createClientV4(createClientV4)
                .build();

        // Tạo SoapEnvelope bằng builder
        SoapEnvelope requestEnvelope = SoapEnvelope.builder()
                .header(header)
                .body(body)
                .build();

        // Gửi request qua WebServiceTemplate
        webServiceTemplate.marshalSendAndReceive(requestEnvelope);
    }
}