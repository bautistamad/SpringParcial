package ar.edu.ubp.das.rest.repository;

import ar.edu.ubp.das.rest.soap.*;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;

public class SoapClient  extends WebServiceGatewaySupport {
	
	public GetTiposServiciosResponse getTipos() {
		System.out.println("ENTRE AL CLIENT");
		GetTiposServicios request = new GetTiposServicios();
//        GetTiposServiciosResponse res = (GetTiposServiciosResponse) getWebServiceTemplate()
//        		.marshalSendAndReceive("http://localhost:8080/ServicioParcialWS/services/TiposServiciosWSPort",request, new SoapActionCallback("http://localhost:8080/ServicioParcialWS/services/TiposServiciosWSPort/getTiposServicios"));    
        JAXBElement<?> res = (JAXBElement<?>) getWebServiceTemplate()
        		.marshalSendAndReceive("http://localhost:8080/ServicioParcialWS/services/TiposServiciosWSPort",request, new SoapActionCallback("http://localhost:8080/ServicioParcialWS/services/TiposServiciosWSPort/getTiposServicios"));    
        System.out.println("RES:" + res);
//        return (GetBankResponseType) res.getValue();
        return (GetTiposServiciosResponse) res.getValue();
	}
	
}
