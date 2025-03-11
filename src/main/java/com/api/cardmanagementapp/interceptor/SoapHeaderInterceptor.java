package com.api.cardmanagementapp.interceptor;

import com.api.cardmanagementapp.constant.NamespaceConstants;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.namespace.QName;

public class SoapHeaderInterceptor {

    public static WebServiceMessageCallback addDefaultHeaders(String sessionContextStr, String userInfo, String correlationId) {
        return message -> {
            SoapMessage soapMessage = (SoapMessage) message;
            SoapHeader header = soapMessage.getSoapHeader();

            // Thêm SessionContextStr
            if (sessionContextStr != null) {
                addHeaderElement(header, "SessionContextStr", sessionContextStr);
            }

            // Thêm UserInfo
            if (userInfo != null) {
                addHeaderElement(header, "UserInfo", userInfo);
            }

            // Thêm CorrelationId
            if (correlationId != null) {
                addHeaderElement(header, "CorrelationId", correlationId);
            }
        };
    }

    private static void addHeaderElement(SoapHeader header, String localName, String value) {
        QName qName = new QName(NamespaceConstants.WSINT_NS, localName);
        header.addHeaderElement(qName).setText(value);
    }
}