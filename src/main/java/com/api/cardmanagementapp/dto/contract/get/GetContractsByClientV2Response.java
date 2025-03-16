package com.api.cardmanagementapp.dto.contract.get;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "GetContractsByClientV2Response", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class GetContractsByClientV2Response {
    @XmlElement
    private String retCode;
    private String resultInfo;
    private OutObject outObject;
}
