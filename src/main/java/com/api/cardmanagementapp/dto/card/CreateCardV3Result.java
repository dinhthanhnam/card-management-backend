package com.api.cardmanagementapp.dto.card;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateCardV3Result", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCardV3Result {
    @XmlElement(name = "CreatedCard", namespace = "http://www.openwaygroup.com/wsint")
    private String createdCard;

    @XmlElement(name = "CardNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String cardNumber;

    @XmlElement(name = "ExpiryDate", namespace = "http://www.openwaygroup.com/wsint")
    private String expiryDate;

    @XmlElement(name = "SequenceNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String sequenceNumber;

    @XmlElement(name = "RetCode", namespace = "http://www.openwaygroup.com/wsint")
    private String retCode;

    @XmlElement(name = "RetMsg", namespace = "http://www.openwaygroup.com/wsint")
    private String retMsg;
    @XmlElement(name = "ResultInfo", namespace = "http://www.openwaygroup.com/wsint")
    private String resultInfo;
}
