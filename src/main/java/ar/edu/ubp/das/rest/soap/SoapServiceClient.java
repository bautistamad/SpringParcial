package ar.edu.ubp.das.rest.soap;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;

import ar.edu.ubp.das.rest.beans.Tipos;

@Component
public class SoapServiceClient implements SoapServiceClientImpl{

	private static final String SERVICE_URL = "http://localhost:8085/ParcialWS/services/ParcialWSPort?wsdl";
	
	private final SoapServiceClientImpl soapServiceClientImpl;
	
	public SoapServiceClient() {
        // Configurar el proxy aquí, evitando crear una nueva instancia de SoapServiceClient
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(SoapServiceClientImpl.class);
        factory.setAddress(SERVICE_URL);

        this.soapServiceClientImpl = (SoapServiceClientImpl) factory.create();
    }
	
	@Override
	public List<Tipos> getTiposServicios() {
		

        // Llama al método en el servicio SOAP
        return soapServiceClientImpl.getTiposServicios();
	}

}
