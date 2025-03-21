package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.card.*;
import com.api.cardmanagementapp.interceptor.SoapHeaderInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;


@Service
@RequiredArgsConstructor
public class CardService {
    private final WebServiceTemplate webServiceTemplate;

    public CreateCardV3Response sendCreateCardRequest(CreateCardV3 createCardV3,
                                                      String sessionContextStr,
                                                      String userInfo,
                                                      String correlationId) {
        // Gọi SOAP request và ép kiểu kết quả trả về thành CreateCardV3Response
        return (CreateCardV3Response) webServiceTemplate.marshalSendAndReceive(
                createCardV3,
                SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }

    public SetCardStatusResponse sendSetCardStatusRequest(SetCardStatus setCardStatus,
                                                          String sessionContextStr,
                                                          String userInfo,
                                                          String correlationId
    ) {
        return (SetCardStatusResponse) webServiceTemplate.marshalSendAndReceive(
                setCardStatus,
                SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }
    public ActivateCardResponse sendSetCardStatusRequest(ActivateCard activateCard,
                                                         String sessionContextStr,
                                                         String userInfo,
                                                         String correlationId
    ) {
        return (ActivateCardResponse) webServiceTemplate.marshalSendAndReceive(
                activateCard,
                SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }
}
