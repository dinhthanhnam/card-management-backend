package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "ActivateCardResponse", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivateCardResponse {
    @XmlElement(name = "ActivateCardResult", namespace = NamespaceConstants.WSINT_NS)
    private ActivateCardResult activateCardResult;
}
