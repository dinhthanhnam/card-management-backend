package com.api.cardmanagementapp.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.transport.WebServiceConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class XmlLoggingInterceptor implements ClientInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(XmlLoggingInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            messageContext.getRequest().writeTo(out);
            String xmlRequest = out.toString("UTF-8");
            logger.info("Request XML: \n{}", xmlRequest);
        } catch (IOException e) {
            logger.error("Lỗi khi log request XML: {}", e.getMessage(), e);
        }
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            messageContext.getResponse().writeTo(out);
            String xmlResponse = out.toString("UTF-8");
            logger.info("Response XML: \n{}", xmlResponse);
        } catch (IOException e) {
            logger.error("Lỗi khi log response XML: {}", e.getMessage(), e);
        }
        return true; // Không log response ở đây, chỉ log request
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {
        // Không làm gì sau khi hoàn tất
    }
}