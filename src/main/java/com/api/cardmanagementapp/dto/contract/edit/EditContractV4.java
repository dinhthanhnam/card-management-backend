package com.api.cardmanagementapp.dto.contract.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import com.api.cardmanagementapp.dto.common.SetCustomDataInObject;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "EditContractV4", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditContractV4 {

    @XmlElement(name = "ContractSearchMethod", namespace = NamespaceConstants.WSINT_NS)
    private String contractSearchMethod;

    @XmlElement(name = "ContractIdentifier", namespace = NamespaceConstants.WSINT_NS)
    private String contractIdentifier;

    @XmlElement(name = "Reason", namespace = NamespaceConstants.WSINT_NS)
    private String reason;

    @XmlElement(name = "EditContract_InObject", namespace = NamespaceConstants.WSINT_NS)
    private EditContractInObject editContractInObject;

    @XmlElement(name = "SetCustomData_InObject", namespace = NamespaceConstants.WSINT_NS)
    private List<SetCustomDataInObject> setCustomDataInObjects;
}
