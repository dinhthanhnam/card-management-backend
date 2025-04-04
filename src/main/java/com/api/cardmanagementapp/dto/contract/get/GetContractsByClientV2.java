package com.api.cardmanagementapp.dto.contract.get;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "GetContractsByClientV2", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class GetContractsByClientV2 {
    @XmlElement(name = "ClientSearchMethod", namespace = NamespaceConstants.WSINT_NS)
    private String clientSearchMethod;
    @XmlElement(name = "ClientIdentifier", namespace = NamespaceConstants.WSINT_NS)
    private String clientIdentifier;
}
