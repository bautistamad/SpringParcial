package ar.edu.ubp.das.rest.soap;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;

import ar.edu.ubp.das.rest.beans.Tipos;

@Component
public class SoapServiceClient implements SoapServiceClientImpl{

	private static final String SERVICE_URL = "http://localhost:8080/ServicioParcialWS/services/TiposServiciosWSPort?wsdl";
	
	private final SoapServiceClientImpl soapServiceClientImpl;
	
	public SoapServiceClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(SoapServiceClientImpl.class);
        factory.setAddress(SERVICE_URL);

        this.soapServiceClientImpl = (SoapServiceClientImpl) factory.create();
    }
	
	@Override
	public List<Tipos> getTiposServicios() {
		
        return soapServiceClientImpl.getTiposServicios();
	}

}
