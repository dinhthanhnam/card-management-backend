package com.api.cardmanagementapp.dto.client.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import com.api.cardmanagementapp.dto.common.SetCustomDataInObject;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "EditClientV6", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditClientV6 {
    @XmlElement(name = "ClientSearchMethod", namespace = NamespaceConstants.WSINT_NS)
    private String clientSearchMethod;

    @XmlElement(name = "ClientIdentifier", namespace = NamespaceConstants.WSINT_NS)
    private String clientIdentifier;

    @XmlElement(name = "Reason", namespace = NamespaceConstants.WSINT_NS)
    private String reason;

    @XmlElement(name = "EditClient_InObject", namespace = NamespaceConstants.WSINT_NS)
    private EditClientInObject editClientInObject;

    @XmlElement(name = "SetCustomData_InObject", namespace = NamespaceConstants.WSINT_NS)
    private SetCustomDataInObject setCustomDataInObjects;
}
