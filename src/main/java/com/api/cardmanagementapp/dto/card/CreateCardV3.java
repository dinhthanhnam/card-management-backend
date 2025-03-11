package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@Data
@XmlRootElement(name = "CreateCardV3", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCardV3 {
    @XmlElement(name = "ContractSearchMethod", namespace = "http://www.openwaygroup.com/wsint")
    private String contractSearchMethod;

    @XmlElement(name = "ContractIdentifier", namespace = "http://www.openwaygroup.com/wsint")
    private String contractIdentifier;

    @XmlElement(name = "ProductCode", namespace = "http://www.openwaygroup.com/wsint")
    private String productCode;

    @XmlElement(name = "ProductCode2", namespace = "http://www.openwaygroup.com/wsint")
    private String productCode2;

    @XmlElement(name = "ProductCode3", namespace = "http://www.openwaygroup.com/wsint")
    private String productCode3;

    @XmlElement(name = "InObject", namespace = "http://www.openwaygroup.com/wsint")
    private CreateCardInObject createCardInObject;
}
