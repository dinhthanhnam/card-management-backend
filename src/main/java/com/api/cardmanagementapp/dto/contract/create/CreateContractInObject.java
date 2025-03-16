package com.api.cardmanagementapp.dto.contract.create;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateContract_InObject", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateContractInObject {
    @XmlElement(name = "Branch", namespace = "http://www.openwaygroup.com/wsint")
    private String branch;

    @XmlElement(name = "InstitutionCode", namespace = "http://www.openwaygroup.com/wsint")
    private String institutionCode;

    @XmlElement(name = "ProductCode", namespace = "http://www.openwaygroup.com/wsint")
    private String productCode;

    @XmlElement(name = "ProductCode2", namespace = "http://www.openwaygroup.com/wsint")
    private String productCode2;

    @XmlElement(name = "ProductCode3", namespace = "http://www.openwaygroup.com/wsint")
    private String productCode3;

    @XmlElement(name = "ContractName", namespace = "http://www.openwaygroup.com/wsint")
    private String contractName;

    @XmlElement(name = "CBSNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String cbsNumber;
}
