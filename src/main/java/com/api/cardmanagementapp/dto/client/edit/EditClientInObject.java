package com.api.cardmanagementapp.dto.client.edit;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "EditClient_InObject", namespace = NamespaceConstants.WSINT_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class EditClientInObject {
    @XmlElement(name = "Branch", namespace = NamespaceConstants.WSINT_NS)
    private String branch;

    @XmlElement(name = "ClientCategory", namespace = NamespaceConstants.WSINT_NS)
    private String clientCategory;

    @XmlElement(name = "ServiceGroup", namespace = NamespaceConstants.WSINT_NS)
    private String serviceGroup;

    @XmlElement(name = "ProductCategory", namespace = NamespaceConstants.WSINT_NS)
    private String productCategory;

    @XmlElement(name = "ClientTypeCode", namespace = NamespaceConstants.WSINT_NS)
    private String clientTypeCode;

    @XmlElement(name = "ShortName", namespace = NamespaceConstants.WSINT_NS)
    private String shortName;

    @XmlElement(name = "SalutationCode", namespace = NamespaceConstants.WSINT_NS)
    private String salutationCode;

    @XmlElement(name = "SalutationSuffix", namespace = NamespaceConstants.WSINT_NS)
    private String salutationSuffix;

    @XmlElement(name = "Gender", namespace = NamespaceConstants.WSINT_NS)
    private String gender;

    @XmlElement(name = "FirstName", namespace = NamespaceConstants.WSINT_NS)
    private String firstName;

    @XmlElement(name = "MiddleName", namespace = NamespaceConstants.WSINT_NS)
    private String middleName;

    @XmlElement(name = "LastName", namespace = NamespaceConstants.WSINT_NS)
    private String lastName;

    @XmlElement(name = "BirthDate", namespace = NamespaceConstants.WSINT_NS)
    private String birthDate;

    @XmlElement(name = "BirthPlace", namespace = NamespaceConstants.WSINT_NS)
    private String birthPlace;

    @XmlElement(name = "BirthName", namespace = NamespaceConstants.WSINT_NS)
    private String birthName;

    @XmlElement(name = "LanguageCode", namespace = NamespaceConstants.WSINT_NS)
    private String languageCode;

    @XmlElement(name = "Citizenship", namespace = NamespaceConstants.WSINT_NS)
    private String citizenship;

    @XmlElement(name = "MaritalStatusCode", namespace = NamespaceConstants.WSINT_NS)
    private String maritalStatusCode;

    @XmlElement(name = "TaxBracket", namespace = NamespaceConstants.WSINT_NS)
    private String taxBracket;

    @XmlElement(name = "IndividualTaxpayerNumber", namespace = NamespaceConstants.WSINT_NS)
    private String individualTaxpayerNumber;

    @XmlElement(name = "DateExpire", namespace = NamespaceConstants.WSINT_NS)
    private String dateExpire;

    @XmlElement(name = "HomePhone", namespace = NamespaceConstants.WSINT_NS)
    private String homePhone;

    @XmlElement(name = "MobilePhone", namespace = NamespaceConstants.WSINT_NS)
    private String mobilePhone;

    @XmlElement(name = "BusinessPhone", namespace = NamespaceConstants.WSINT_NS)
    private String businessPhone;

    @XmlElement(name = "HomeFax", namespace = NamespaceConstants.WSINT_NS)
    private String homeFax;

    @XmlElement(name = "BusinessFax", namespace = NamespaceConstants.WSINT_NS)
    private String businessFax;

    @XmlElement(name = "EMail", namespace = NamespaceConstants.WSINT_NS)
    private String email;

    @XmlElement(name = "Country", namespace = NamespaceConstants.WSINT_NS)
    private String country;

    @XmlElement(name = "State", namespace = NamespaceConstants.WSINT_NS)
    private String state;

    @XmlElement(name = "City", namespace = NamespaceConstants.WSINT_NS)
    private String city;

    @XmlElement(name = "AddressZIP", namespace = NamespaceConstants.WSINT_NS)
    private String addressZip;

    @XmlElement(name = "AddressLine1", namespace = NamespaceConstants.WSINT_NS)
    private String addressLine1;

    @XmlElement(name = "AddressLine2", namespace = NamespaceConstants.WSINT_NS)
    private String addressLine2;

    @XmlElement(name = "AddressLine3", namespace = NamespaceConstants.WSINT_NS)
    private String addressLine3;

    @XmlElement(name = "AddressLine4", namespace = NamespaceConstants.WSINT_NS)
    private String addressLine4;

    @XmlElement(name = "CompanyName", namespace = NamespaceConstants.WSINT_NS)
    private String companyName;

    @XmlElement(name = "Trademark", namespace = NamespaceConstants.WSINT_NS)
    private String trademark;

    @XmlElement(name = "Department", namespace = NamespaceConstants.WSINT_NS)
    private String department;

    @XmlElement(name = "PositionCode", namespace = NamespaceConstants.WSINT_NS)
    private String positionCode;

    @XmlElement(name = "Profession", namespace = NamespaceConstants.WSINT_NS)
    private String profession;

    @XmlElement(name = "EmbossedLastName", namespace = NamespaceConstants.WSINT_NS)
    private String embossedLastName;

    @XmlElement(name = "EmbossedFirstName", namespace = NamespaceConstants.WSINT_NS)
    private String embossedFirstName;

    @XmlElement(name = "EmbossedCompanyName", namespace = NamespaceConstants.WSINT_NS)
    private String embossedCompanyName;

    @XmlElement(name = "EmbossedTitleCode", namespace = NamespaceConstants.WSINT_NS)
    private String embossedTitleCode;

    @XmlElement(name = "IdentityCardType", namespace = NamespaceConstants.WSINT_NS)
    private String identityCardType;

    @XmlElement(name = "IdentityCardNumber", namespace = NamespaceConstants.WSINT_NS)
    private String identityCardNumber;

    @XmlElement(name = "IdentityCardDetails", namespace = NamespaceConstants.WSINT_NS)
    private String identityCardDetails;

    @XmlElement(name = "ClientNumber", namespace = NamespaceConstants.WSINT_NS)
    private String clientNumber;

    @XmlElement(name = "SecretPhrase", namespace = NamespaceConstants.WSINT_NS)
    private String secretPhrase;

    @XmlElement(name = "SocialSecurityNumber", namespace = NamespaceConstants.WSINT_NS)
    private String socialSecurityNumber;

    @XmlElement(name = "AddDate01", namespace = NamespaceConstants.WSINT_NS)
    private String addDate01;

    @XmlElement(name = "AddDate02", namespace = NamespaceConstants.WSINT_NS)
    private String addDate02;

    @XmlElement(name = "RegistrationDate", namespace = NamespaceConstants.WSINT_NS)
    private String registrationDate;
}
