package com.api.cardmanagementapp.dto.common;

import com.api.cardmanagementapp.dto.client.CreateClientV4;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoapBody {

    @XmlElement(name = "CreateClientV4", namespace = "http://www.openwaygroup.com/wsint")
    private CreateClientV4 createClientV4;
}