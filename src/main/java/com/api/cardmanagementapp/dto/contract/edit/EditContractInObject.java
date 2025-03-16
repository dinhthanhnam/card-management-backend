package com.api.cardmanagementapp.dto.contract.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "EditContractInObject", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditContractInObject {
    @XmlElement(name = "Branch", namespace = NamespaceConstants.WSINT_NS)
    private String branch;

    @XmlElement(name = "ServiceGroup", namespace = NamespaceConstants.WSINT_NS)
    private String serviceGroup;

    @XmlElement(name = "ServiceGroup", namespace = NamespaceConstants.WSINT_NS)
    private String contractNumber;

    @XmlElement(name = "ContractName", namespace = NamespaceConstants.WSINT_NS)
    private String contractName;

    @XmlElement(name = "CBSID", namespace = NamespaceConstants.WSINT_NS)
    private String cbsID;

    @XmlElement(name = "CBSNumber", namespace = NamespaceConstants.WSINT_NS)
    private String cbsNumber;

    @XmlElement(name = "CloseDate", namespace = NamespaceConstants.WSINT_NS)
    private String closeDate;
}
