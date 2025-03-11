package com.api.cardmanagementapp.dto.common;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "SetCustomData_InObject", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class SetCustomDataInObject {

    @XmlElement(name = "AddInfoType", namespace = "http://www.openwaygroup.com/wsint")
    private String addInfoType;

    @XmlElement(name = "TagName", namespace = "http://www.openwaygroup.com/wsint")
    private String tagName;

    @XmlElement(name = "TagValue", namespace = "http://www.openwaygroup.com/wsint")
    private String tagValue;
}
