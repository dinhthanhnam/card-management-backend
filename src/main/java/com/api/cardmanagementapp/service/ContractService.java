package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.dto.client.edit.EditClientV6;
import com.api.cardmanagementapp.dto.client.edit.EditClientV6Response;
import com.api.cardmanagementapp.dto.contract.create.CreateContractV4;
import com.api.cardmanagementapp.dto.contract.create.CreateContractV4Response;
import com.api.cardmanagementapp.dto.contract.edit.EditContractV4;
import com.api.cardmanagementapp.dto.contract.edit.EditContractV4Response;
import com.api.cardmanagementapp.dto.issuing.CreateIssuingContractWithLiabilityV2;
import com.api.cardmanagementapp.dto.issuing.CreateIssuingContractWithLiabilityV2Response;
import com.api.cardmanagementapp.interceptor.SoapHeaderInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final WebServiceTemplate webServiceTemplate;

    public CreateContractV4Response sendCreateContractRequest(CreateContractV4 createContractV4,
                                                              String sessionContextStr,
                                                              String userInfo,
                                                              String correlationId)
    {
        // Gọi SOAP request và ép kiểu kết quả trả về thành CreateContractV4Response
        return (CreateContractV4Response) webServiceTemplate.marshalSendAndReceive(
                createContractV4,
                SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }

    public CreateIssuingContractWithLiabilityV2Response sendCreateIssuingContractWithLiabilityRequest(CreateIssuingContractWithLiabilityV2 createIssuingContractWithLiabilityV2,
                                                                                                      String sessionContextStr,
                                                                                                      String userInfo,
                                                                                                      String correlationId)
    {
        // Gọi SOAP request và ép kiểu kết quả trả về thành CreateIssuingContractWithLiabilityV2Response
        return (CreateIssuingContractWithLiabilityV2Response) webServiceTemplate.marshalSendAndReceive(
                createIssuingContractWithLiabilityV2,
                SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }

    public EditContractV4Response sendEditContractRequest(EditContractV4 editContractV4,
                                                          String sessionContextStr,
                                                          String userInfo,
                                                          String correlationId)
    {
        return (EditContractV4Response) webServiceTemplate.marshalSendAndReceive(
                editContractV4, SoapHeaderInterceptor.addDefaultHeaders(sessionContextStr, userInfo, correlationId)
        );
    }
}