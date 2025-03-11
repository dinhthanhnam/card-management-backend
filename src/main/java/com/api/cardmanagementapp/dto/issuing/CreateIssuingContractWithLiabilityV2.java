package com.api.cardmanagementapp.dto.issuing;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateIssuingContractWithLiabilityV2", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateIssuingContractWithLiabilityV2 {
    @XmlElement(name = "LiabCategory", namespace = "http://www.openwaygroup.com/wsint")
    private String liabCategory;

    @XmlElement(name = "LiabContractSearchMethod", namespace = "http://www.openwaygroup.com/wsint")
    private String liabContractSearchMethod;

    @XmlElement(name = "LiabContractIdentifier", namespace = "http://www.openwaygroup.com/wsint")
    private String liabContractIdentifier;

    @XmlElement(name = "InObject", namespace = "http://www.openwaygroup.com/wsint")
    private CreateIssuingInObject createIssuingInObject;
}
