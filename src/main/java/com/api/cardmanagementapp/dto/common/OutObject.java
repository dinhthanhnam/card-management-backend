package com.api.cardmanagementapp.dto.common;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "OutObject", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class OutObject {
    @XmlElement(name = "IssContractDetailsAPIOutputV2Record")
    private IssContractDetailsAPIOutputV2Record issContractDetailsAPIOutputV2Record;
}
