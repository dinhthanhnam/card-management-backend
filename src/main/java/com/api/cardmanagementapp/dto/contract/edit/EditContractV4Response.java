package com.api.cardmanagementapp.dto.contract.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "EditContractV4Response", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditContractV4Response {
    @XmlElement(name = "EditContractV4Result", namespace = NamespaceConstants.WSINT_NS)
    private EditContractV4Result editContractV4Result;
}
