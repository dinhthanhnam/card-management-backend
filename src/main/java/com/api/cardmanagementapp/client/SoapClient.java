package com.api.cardmanagementapp.client;

import com.api.cardmanagementapp.dto.client.CreateClientInObject;
import com.api.cardmanagementapp.dto.client.CreateClientV4;
import com.api.cardmanagementapp.dto.common.SoapBody;
import com.api.cardmanagementapp.dto.common.SoapEnvelope;
import com.api.cardmanagementapp.dto.common.SoapHeader;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class SoapClient {

    private final WebServiceTemplate webServiceTemplate;
    private final Jaxb2Marshaller marshaller;

    public SoapClient(WebServiceTemplate webServiceTemplate, Jaxb2Marshaller marshaller) {
        this.webServiceTemplate = webServiceTemplate;
        this.marshaller = marshaller;
    }

    public void sendCreateClientRequest() throws Exception {
        // Tạo CreateClientV4
        CreateClientV4 request = new CreateClientV4();
        request.setReason("Create lient");

        CreateClientInObject clientInObject = new CreateClientInObject();
        clientInObject.setInstitutionCode("0001");
        clientInObject.setBranch("001");
        clientInObject.setClientTypeCode("PR");
        clientInObject.setShortName("Truong Ha Anh");
        clientInObject.setFirstName("Anh");
        clientInObject.setLastName("Truong");
        clientInObject.setMiddleName("Ha");
        clientInObject.setMaritalStatusCode("D");
        clientInObject.setSocialSecurityNumber("234550004319");
        clientInObject.setSalutationCode("MR");
        clientInObject.setBirthDate("2000-12-12");
        clientInObject.setGender("F");
        clientInObject.setCitizenship("VNM");
        clientInObject.setIndividualTaxpayerNumber("43245665619");
        clientInObject.setCompanyName("OPenWay");
        clientInObject.setIdentityCardNumber("0997765539");
        clientInObject.setIdentityCardDetails("232445213hanoi");
        clientInObject.setClientNumber("099773245419");
        clientInObject.setProfession("Thu Ky");
        clientInObject.setEMail("linhdt@gmail.com");
        clientInObject.setAddressLine1("54 Lieu Giai Doi Can Ba Dinh");
        clientInObject.setCity("HaNoi");
        clientInObject.setHomePhone("0875433001");
        clientInObject.setMobilePhone("087543002");

        request.setCreateClientInObject(clientInObject);

        // Tạo SoapBody
        SoapBody body = new SoapBody();
        body.setCreateClientV4(request);

        // Tạo SoapHeader
        SoapHeader header = new SoapHeader();
        header.setSessionContextStr("?");
        header.setUserInfo("officer=\"WX_ADMIN\"");
        header.setCorrelationId("?");

        // Tạo SoapEnvelope
        SoapEnvelope envelope = new SoapEnvelope();
        envelope.setHeader(header);
        envelope.setBody(body);

        // Marshal thành XML và in ra
        StringWriter writer = new StringWriter();
        marshaller.marshal(envelope, new StreamResult(writer));
        String xmlOutput = writer.toString();
        System.out.println("Generated SOAP XML:\n" + xmlOutput);
    }

    public static void main(String[] args) throws Exception {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.api.cardmanagementapp.dto");
        marshaller.afterPropertiesSet();

        WebServiceTemplate template = new WebServiceTemplate(marshaller);
        SoapClient client = new SoapClient(template, marshaller);
        client.sendCreateClientRequest();
    }
}