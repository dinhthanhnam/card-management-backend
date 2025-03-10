package com.api.cardmanagementapp.dto.client;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateClientV4", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateClientV4 {

    @XmlElement(name = "Reason", namespace = "http://www.openwaygroup.com/wsint")
    private String reason;

    @XmlElement(name = "CreateClient_InObject", namespace = "http://www.openwaygroup.com/wsint")
    private CreateClientInObject createClientInObject;

    // Không cần tự viết getter/setter, để Lombok xử lý
}