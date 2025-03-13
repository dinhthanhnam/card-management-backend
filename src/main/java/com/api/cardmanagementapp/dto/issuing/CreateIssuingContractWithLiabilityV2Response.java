package com.api.cardmanagementapp.dto.issuing;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import com.api.cardmanagementapp.dto.card.CreateCardV3Result;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateIssuingContractWithLiabilityV2Response", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateIssuingContractWithLiabilityV2Response {
    @XmlElement(name = "CreateIssuingContractWithLiabilityV2Result",namespace = NamespaceConstants.WSINT_NS)
    private CreateIssuingContractWithLiabilityV2Result createIssuingContractWithLiabilityV2Result;
}
