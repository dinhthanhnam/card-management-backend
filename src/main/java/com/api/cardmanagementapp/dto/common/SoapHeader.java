package com.api.cardmanagementapp.dto.common;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@XmlRootElement(name = "Header", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoapHeader {

    @XmlElement(name = "SessionContextStr", namespace = "http://www.openwaygroup.com/wsint")
    private String sessionContextStr;

    @XmlElement(name = "UserInfo", namespace = "http://www.openwaygroup.com/wsint")
    private String userInfo;

    @XmlElement(name = "CorrelationId", namespace = "http://www.openwaygroup.com/wsint")
    private String correlationId;
}