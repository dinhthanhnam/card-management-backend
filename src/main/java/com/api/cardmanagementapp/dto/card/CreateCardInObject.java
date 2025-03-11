package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "InObject", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCardInObject {
    @XmlElement(name = "CardName", namespace = "http://www.openwaygroup.com/wsint")
    private String cardName;

    @XmlElement(name = "CBSNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String cbsNumber;

    @XmlElement(name = "EmbossedFirstName", namespace = "http://www.openwaygroup.com/wsint")
    private String embossedFirstName;

    @XmlElement(name = "EmbossedLastName", namespace = "http://www.openwaygroup.com/wsint")
    private String embossedLastName;

    @XmlElement(name = "EmbossedCompanyName", namespace = "http://www.openwaygroup.com/wsint")
    private String embossedCompanyName;
}
