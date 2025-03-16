package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.client.create.CreateClientV4;
import com.api.cardmanagementapp.dto.client.create.CreateClientV4Response;
import com.api.cardmanagementapp.dto.client.edit.EditClientV6;
import com.api.cardmanagementapp.dto.client.edit.EditClientV6Response;
import com.api.cardmanagementapp.interceptor.SoapHeaderInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final WebServiceTemplate webServiceTemplate;

    public CreateClientV4Response sendCreateClientRequest(CreateClientV4 createClientV4,
                                                          String sessionContextStr,
                                                          String userInfo,
                                                          String correlationId)
    {
        // Gọi SOAP request và ép kiểu kết quả trả về thành CreateClientV4Response
        return (CreateClientV4Response) webServiceTemplate.marshalSendAndReceive(
            createClientV4, SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }

    public EditClientV6Response sendEditClientRequest(EditClientV6 editClientV6,
                                                      String sessionContextStr,
                                                      String userInfo,
                                                      String correlationId)
    {
        // Gọi SOAP request và ép kiểu kết quả trả về thành CreateClientV4Response
        return (EditClientV6Response) webServiceTemplate.marshalSendAndReceive(
                editClientV6, SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }
}
