package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "SetCardStatusResult", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class SetCardStatusResult {
    @XmlElement(name = "RetCode", namespace = NamespaceConstants.WSINT_NS)
    private int retCode;

    @XmlElement(name = "RetMsg", namespace = NamespaceConstants.WSINT_NS)
    private String retMsg;

    @XmlElement(name = "RetInfo", namespace = NamespaceConstants.WSINT_NS)
    private String retInfo;
}
