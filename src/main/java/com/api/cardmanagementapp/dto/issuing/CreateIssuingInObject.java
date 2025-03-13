package com.api.cardmanagementapp.dto.issuing;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "InObject", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateIssuingInObject {
    @XmlElement(name ="Branch", namespace = "http://www.openwaygroup.com/wsint")
    private String branch;

    @XmlElement(name = "InstitutionCode", namespace = "http://www.openwaygroup.com/wsint")
    private String institutionCode;

    @XmlElement(name = "ContractName", namespace = "http://www.openwaygroup.com/wsint")
    private String contractName;

    @XmlElement(name = "CBSNumber", namespace = NamespaceConstants.WSINT_NS)
    private String cbsNumber;

    @XmlElement(name = "AddInfo01", namespace = "http://www.openwaygroup.com/wsint")
    private String addInfo01;

    @XmlElement(name = "AddInfo02", namespace = "http://www.openwaygroup.com/wsint")
    private String addInfo02;
}
