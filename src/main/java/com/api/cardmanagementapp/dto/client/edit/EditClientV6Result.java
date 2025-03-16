package com.api.cardmanagementapp.dto.client.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "EditClientV6Result", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditClientV6Result {
    @XmlElement(name = "RetCode", namespace = "http://www.openwaygroup.com/wsint")
    private String retCode;

    @XmlElement(name = "RetMsg", namespace = "http://www.openwaygroup.com/wsint")
    private String retMsg;

    @XmlElement(name = "ResultInfo", namespace = "http://www.openwaygroup.com/wsint")
    private String resultInfo;
}
