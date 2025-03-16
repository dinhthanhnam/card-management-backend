package com.api.cardmanagementapp.dto.client.create;

import com.api.cardmanagementapp.dto.common.SetCustomDataInObject;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "CreateClientV4", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateClientV4 {

    @XmlElement(name = "Reason", namespace = "http://www.openwaygroup.com/wsint")
    private String reason;

    @XmlElement(name = "CreateClient_InObject", namespace = "http://www.openwaygroup.com/wsint")
    private CreateClientInObject createClientInObject;

    @XmlElement(name = "SetCustomData_InObject", namespace = "http://www.openwaygroup.com/wsint")
    List<SetCustomDataInObject> setCustomDataInObjects;

    // Không cần tự viết getter/setter, để Lombok xử lý
}