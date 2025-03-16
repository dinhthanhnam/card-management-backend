package com.api.cardmanagementapp.dto.contract.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "EditContractV4", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditContractV4Result {
    @XmlElement(name = "RetCode", namespace = NamespaceConstants.WSINT_NS)
    private String retCode;

    @XmlElement(name = "RetMsg", namespace = NamespaceConstants.WSINT_NS)
    private String retMsg;

    @XmlElement(name = "ResultInfo", namespace = NamespaceConstants.WSINT_NS)
    private String resultInfo;
}

