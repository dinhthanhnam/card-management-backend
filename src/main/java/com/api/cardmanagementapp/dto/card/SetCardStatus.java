package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "SetCardStatus", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class SetCardStatus {
    @XmlElement(name = "ContractSearchMethod", namespace = NamespaceConstants.WSINT_NS)
    private String contractSearchMethod;

    @XmlElement(name = "ContractIdentifier", namespace = NamespaceConstants.WSINT_NS)
    private String contractIdentifier;

    @XmlElement(name = "NewStatus", namespace = NamespaceConstants.WSINT_NS)
    private String newStatus;

    @XmlElement(name = "Reason", namespace = NamespaceConstants.WSINT_NS)
    private String reason;
}
