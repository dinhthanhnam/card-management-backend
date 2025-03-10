package com.api.cardmanagementapp.dto.client;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "CreateClient_InObject", namespace = "http://www.openwaygroup.com/wsint")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateClientInObject {

    @XmlElement(name = "InstitutionCode", namespace = "http://www.openwaygroup.com/wsint")
    private String institutionCode;

    @XmlElement(name = "Branch", namespace = "http://www.openwaygroup.com/wsint")
    private String branch;

    @XmlElement(name = "ClientTypeCode", namespace = "http://www.openwaygroup.com/wsint")
    private String clientTypeCode;

    @XmlElement(name = "ShortName", namespace = "http://www.openwaygroup.com/wsint")
    private String shortName;

    @XmlElement(name = "FirstName", namespace = "http://www.openwaygroup.com/wsint")
    private String firstName;

    @XmlElement(name = "LastName", namespace = "http://www.openwaygroup.com/wsint")
    private String lastName;

    @XmlElement(name = "MiddleName", namespace = "http://www.openwaygroup.com/wsint")
    private String middleName;

    @XmlElement(name = "MaritalStatusCode", namespace = "http://www.openwaygroup.com/wsint")
    private String maritalStatusCode;

    @XmlElement(name = "SocialSecurityNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String socialSecurityNumber;

    @XmlElement(name = "SalutationCode", namespace = "http://www.openwaygroup.com/wsint")
    private String salutationCode;

    @XmlElement(name = "BirthDate", namespace = "http://www.openwaygroup.com/wsint")
    private String birthDate;

    @XmlElement(name = "Gender", namespace = "http://www.openwaygroup.com/wsint")
    private String gender;

    @XmlElement(name = "Citizenship", namespace = "http://www.openwaygroup.com/wsint")
    private String citizenship;

    @XmlElement(name = "IndividualTaxpayerNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String individualTaxpayerNumber;

    @XmlElement(name = "CompanyName", namespace = "http://www.openwaygroup.com/wsint")
    private String companyName;

    @XmlElement(name = "IdentityCardNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String identityCardNumber;

    @XmlElement(name = "IdentityCardDetails", namespace = "http://www.openwaygroup.com/wsint")
    private String identityCardDetails;

    @XmlElement(name = "ClientNumber", namespace = "http://www.openwaygroup.com/wsint")
    private String clientNumber;

    @XmlElement(name = "Profession", namespace = "http://www.openwaygroup.com/wsint")
    private String profession;

    @XmlElement(name = "EMail", namespace = "http://www.openwaygroup.com/wsint")
    private String eMail;

    @XmlElement(name = "AddressLine1", namespace = "http://www.openwaygroup.com/wsint")
    private String addressLine1;

    @XmlElement(name = "City", namespace = "http://www.openwaygroup.com/wsint")
    private String city;

    @XmlElement(name = "HomePhone", namespace = "http://www.openwaygroup.com/wsint")
    private String homePhone;

    @XmlElement(name = "MobilePhone", namespace = "http://www.openwaygroup.com/wsint")
    private String mobilePhone;

    // Không cần tự viết getter/setter, để Lombok xử lý
}