package com.api.cardmanagementapp.dto.common;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "IssContractDetailsAPIOutputV2Record", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class IssContractDetailsAPIOutputV2Record {

    @XmlElement(name = "Institution", namespace = NamespaceConstants.WSINT_NS)
    private String institution;

    @XmlElement(name = "Branch", namespace = NamespaceConstants.WSINT_NS)
    private String branch;

    @XmlElement(name = "ClientCategory", namespace = NamespaceConstants.WSINT_NS)
    private String clientCategory;

    @XmlElement(name = "ClientType", namespace = NamespaceConstants.WSINT_NS)
    private String clientType;

    @XmlElement(name = "ProductCategory", namespace = NamespaceConstants.WSINT_NS)
    private String productCategory;

    @XmlElement(name = "RedefinedProductCategory", namespace = NamespaceConstants.WSINT_NS)
    private String redefinedProductCategory;

    @XmlElement(name = "ContractCategory", namespace = NamespaceConstants.WSINT_NS)
    private String contractCategory;

    @XmlElement(name = "MainProductCorrected", namespace = NamespaceConstants.WSINT_NS)
    private String mainProductCorrected;

    @XmlElement(name = "MainProductITD", namespace = NamespaceConstants.WSINT_NS)
    private String mainProductITD;

    @XmlElement(name = "Product", namespace = NamespaceConstants.WSINT_NS)
    private String product;

    @XmlElement(name = "ContractSubtype", namespace = NamespaceConstants.WSINT_NS)
    private String contractSubtype;

    @XmlElement(name = "ReportType", namespace = NamespaceConstants.WSINT_NS)
    private String reportType;

    @XmlElement(name = "Role", namespace = NamespaceConstants.WSINT_NS)
    private String role;

    @XmlElement(name = "Icon", namespace = NamespaceConstants.WSINT_NS)
    private String icon;

    @XmlElement(name = "Leaf", namespace = NamespaceConstants.WSINT_NS)
    private String leaf;

    @XmlElement(name = "Currency", namespace = NamespaceConstants.WSINT_NS)
    private String currency;

    @XmlElement(name = "Available", namespace = NamespaceConstants.WSINT_NS)
    private String available;

    @XmlElement(name = "Balance", namespace = NamespaceConstants.WSINT_NS)
    private String balance;

    @XmlElement(name = "CreditLimit", namespace = NamespaceConstants.WSINT_NS)
    private String creditLimit;

    @XmlElement(name = "AddLimit", namespace = NamespaceConstants.WSINT_NS)
    private String addLimit;

    @XmlElement(name = "Blocked", namespace = NamespaceConstants.WSINT_NS)
    private String blocked;

    @XmlElement(name = "TotalDue", namespace = NamespaceConstants.WSINT_NS)
    private String totalDue;

    @XmlElement(name = "PastDue", namespace = NamespaceConstants.WSINT_NS)
    private String pastDue;

    @XmlElement(name = "ShadowAuthLimit", namespace = NamespaceConstants.WSINT_NS)
    private String shadowAuthLimit;

    @XmlElement(name = "Client", namespace = NamespaceConstants.WSINT_NS)
    private String client;

    @XmlElement(name = "ContractNumber", namespace = NamespaceConstants.WSINT_NS)
    private String contractNumber;

    @XmlElement(name = "SafeContractNumber", namespace = NamespaceConstants.WSINT_NS)
    private String safeContractNumber;

    @XmlElement(name = "ContractName", namespace = NamespaceConstants.WSINT_NS)
    private String contractName;

    @XmlElement(name = "ContractLevel", namespace = NamespaceConstants.WSINT_NS)
    private String contractLevel;

    @XmlElement(name = "BillingContact", namespace = NamespaceConstants.WSINT_NS)
    private String billingContact;

    @XmlElement(name = "TopContract", namespace = NamespaceConstants.WSINT_NS)
    private String topContract;

    @XmlElement(name = "CBSNumber", namespace = NamespaceConstants.WSINT_NS)
    private String cbsNumber;

    @XmlElement(name = "OpenDate", namespace = NamespaceConstants.WSINT_NS)
    private String openDate;

    @XmlElement(name = "CheckUsage", namespace = NamespaceConstants.WSINT_NS)
    private String checkUsage;

    @XmlElement(name = "LastBillingDate", namespace = NamespaceConstants.WSINT_NS)
    private String lastBillingDate;

    @XmlElement(name = "NextBillingDate", namespace = NamespaceConstants.WSINT_NS)
    private String nextBillingDate;

    @XmlElement(name = "PastDueDays", namespace = NamespaceConstants.WSINT_NS)
    private String pastDueDays;

    @XmlElement(name = "AddParmString", namespace = NamespaceConstants.WSINT_NS)
    private String addParmString;

    @XmlElement(name = "Status", namespace = NamespaceConstants.WSINT_NS)
    private String status;

    @XmlElement(name = "StatusCode", namespace = NamespaceConstants.WSINT_NS)
    private String statusCode;

    @XmlElement(name = "ExternalCode", namespace = NamespaceConstants.WSINT_NS)
    private String externalCode;

    @XmlElement(name = "LastApplicationDate", namespace = NamespaceConstants.WSINT_NS)
    private String lastApplicationDate;

    @XmlElement(name = "LastApplicationOfficer", namespace = NamespaceConstants.WSINT_NS)
    private String lastApplicationOfficer;

    @XmlElement(name = "LastApplicationStatus", namespace = NamespaceConstants.WSINT_NS)
    private String lastApplicationStatus;

    @XmlElement(name = "LastActivityDate", namespace = NamespaceConstants.WSINT_NS)
    private String lastActivityDate;

    @XmlElement(name = "Ready", namespace = NamespaceConstants.WSINT_NS)
    private String ready;

    @XmlElement(name = "AmendmentDate", namespace = NamespaceConstants.WSINT_NS)
    private String amendmentDate;

    @XmlElement(name = "AmendmentOfficer", namespace = NamespaceConstants.WSINT_NS)
    private String amendmentOfficer;

    @XmlElement(name = "ID", namespace = NamespaceConstants.WSINT_NS)
    private String id;

    @XmlElement(name = "ClientFullName", namespace = NamespaceConstants.WSINT_NS)
    private String clientFullName;

    @XmlElement(name = "ProductCode", namespace = NamespaceConstants.WSINT_NS)
    private String productCode;

    @XmlElement(name = "MainProductCode", namespace = NamespaceConstants.WSINT_NS)
    private String mainProductCode;

}
