package com.api.cardmanagementapp.dto.client.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "EditClientV6Response", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditClientV6Response {
    @XmlElement(name = "EditClientV6Result", namespace = NamespaceConstants.WSINT_NS)
    private EditClientV6Result editClientV6Result;
}
