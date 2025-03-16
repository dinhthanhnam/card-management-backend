package com.api.cardmanagementapp.dto.contract.create;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "CreateContractV4Response", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
@Data

public class CreateContractV4Response {
    @XmlElement(name = "CreateContractV4Result", namespace = "http://www.openwaygroup.com/wsint")
    private CreateContractV4Result createContractV4Result;
}
