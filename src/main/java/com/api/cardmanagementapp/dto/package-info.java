@jakarta.xml.bind.annotation.XmlSchema(
        namespace = "http://schemas.xmlsoap.org/soap/envelope/",
        elementFormDefault = jakarta.xml.bind.annotation.XmlNsForm.QUALIFIED,
        xmlns = {
                @jakarta.xml.bind.annotation.XmlNs(prefix = "soapenv", namespaceURI = "http://schemas.xmlsoap.org/soap/envelope/"),
                @jakarta.xml.bind.annotation.XmlNs(prefix = "wsin", namespaceURI = "http://www.openwaygroup.com/wsint")
        }
)
package com.api.cardmanagementapp.dto;