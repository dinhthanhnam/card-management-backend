package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "ActivateCard", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivateCard {
    @XmlElement(name = "ContractSearchMethod", namespace = NamespaceConstants.WSINT_NS)
    private String contractSearchMethod;

    @XmlElement(name = "ContractIdentifier", namespace = NamespaceConstants.WSINT_NS)
    private String contractIdentifier;

    @XmlElement(name = "Reason", namespace = NamespaceConstants.WSINT_NS)
    private String reason;
}
