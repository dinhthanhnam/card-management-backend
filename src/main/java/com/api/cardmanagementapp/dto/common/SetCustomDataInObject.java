package com.api.cardmanagementapp.dto.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@XmlRootElement(name = "SetCustomData_InObject", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class SetCustomDataInObject {
    @XmlElement
    private String addInfoType;

    @XmlElement
    private String tagName;

    @XmlElement
    private String tagValue;
}
