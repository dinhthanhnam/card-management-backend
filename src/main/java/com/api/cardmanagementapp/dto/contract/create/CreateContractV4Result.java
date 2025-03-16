package com.api.cardmanagementapp.dto.contract.create;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateContractV4Result", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateContractV4Result {
    @XmlElement(name = "CreatedContract", namespace = "http://www.openwaygroup.com/wsint")
    private String createdContract;

    @XmlElement(name = "ContractNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String contractNumber;

    @XmlElement(name = "ApplicationNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String applicationNumber;

    @XmlElement(name = "RetCode", namespace = "http://www.openwaygroup.com/wsint")
    private String retCode;

    @XmlElement(name = "RetMsg", namespace = "http://www.openwaygroup.com/wsint")
    private String retMsg;

    @XmlElement(name = "ResultInfo", namespace = "http://www.openwaygroup.com/wsint")
    private String resultInfo;
}
