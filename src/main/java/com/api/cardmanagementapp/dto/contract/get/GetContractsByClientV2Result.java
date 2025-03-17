package com.api.cardmanagementapp.dto.contract.get;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import com.api.cardmanagementapp.dto.common.OutObject;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "GetContractsByClientV2Response", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class GetContractsByClientV2Result {
    @XmlElement(name = "RetCode", namespace = NamespaceConstants.WSINT_NS)
    private String retCode;

    @XmlElement(name = "RetMsg", namespace = NamespaceConstants.WSINT_NS)
    private String retMsg;

    @XmlElement(name = "ResultInfo", namespace = NamespaceConstants.WSINT_NS)
    private String resultInfo;

    @XmlElement(name = "OutObject", namespace = NamespaceConstants.WSINT_NS)
    private OutObject outObject;
}
