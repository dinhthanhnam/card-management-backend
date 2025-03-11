package com.api.cardmanagementapp.dto.client;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "CreateClientV4Response", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CreateClientV4Response {
    @XmlElement(name = "CreateClientV4Result", namespace = "http://www.openwaygroup.com/wsint")
    private CreateClientV4Result createClientV4Result;
}
