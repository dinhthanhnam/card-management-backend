package com.api.cardmanagementapp.dto.contract.create;

import com.api.cardmanagementapp.dto.common.SetCustomDataInObject;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "CreateContractV4", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateContractV4 {
    @XmlElement(name = "ClientSearchMethod", namespace = "http://www.openwaygroup.com/wsint")
    private String clientSearchMethod;

    @XmlElement(name = "ClientIdentifier", namespace = "http://www.openwaygroup.com/wsint")
    private String clientIdentifier;

    @XmlElement(name = "Reason", namespace = "http://www.openwaygroup.com/wsint")
    private String reason;

    @XmlElement(name = "CreateContract_InObject", namespace = "http://www.openwaygroup.com/wsint")
    private CreateContractInObject createContractInObject;

    @XmlElement(name = "SetCustomData_InObject", namespace = "http://www.openwaygroup.com/wsint")
    private List<SetCustomDataInObject> setCustomDataInObjects;
}
