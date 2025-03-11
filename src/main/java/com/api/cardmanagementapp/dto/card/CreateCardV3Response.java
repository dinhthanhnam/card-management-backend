package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateCardV3Response", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCardV3Response {
    @XmlElement(name = "CreateCardV3Result",namespace = "http://www.openwaygroup.com/wsint")
    private CreateCardV3Result createCardV3Result;
}
