package com.api.cardmanagementapp.dto.issuing;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateIssuingContractWithLiabilityV2Result", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateIssuingContractWithLiabilityV2Result {
    @XmlElement(name = "CreatedContract", namespace = NamespaceConstants.WSINT_NS)
    private String createdContract;

    @XmlElement(name = "ContractNumber", namespace = NamespaceConstants.WSINT_NS)
    private String contractNumber;

    @XmlElement(name = "ApplicationNumber", namespace = NamespaceConstants.WSINT_NS)
    private String applicationNumber;

    @XmlElement(name = "RetCode", namespace = NamespaceConstants.WSINT_NS)
    private String retCode;

    @XmlElement(name = "RetMsg", namespace = NamespaceConstants.WSINT_NS)
    private String retMsg;

    @XmlElement(name = "ResultInfo", namespace = NamespaceConstants.WSINT_NS)
    private String resultInfo;
}
