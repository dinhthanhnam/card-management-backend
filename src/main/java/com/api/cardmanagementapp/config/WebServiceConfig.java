package com.api.cardmanagementapp.config;

import com.api.cardmanagementapp.interceptor.SoapHeaderInterceptor;
import com.api.cardmanagementapp.interceptor.XmlLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

@Configuration
public class WebServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(
                "com.api.cardmanagementapp.dto.client",
                "com.api.cardmanagementapp.dto.common",
                "com.api.cardmanagementapp.dto.contract",
                "com.api.cardmanagementapp.dto.card",
                "com.api.cardmanagementapp.dto.issuing"
                ); // Quét package
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri("http://10.145.48.222:17000/webservice_int/ws");
        ClientInterceptor[] interceptors = new ClientInterceptor[]
                {new XmlLoggingInterceptor()};
        template.setInterceptors(interceptors);
        return template;
    }
}