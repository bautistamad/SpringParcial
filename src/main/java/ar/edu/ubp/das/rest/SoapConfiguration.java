package ar.edu.ubp.das.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ar.edu.ubp.das.rest.repository.SoapClient;

@Configuration
public class SoapConfiguration {
	
	 @Bean
	    public Jaxb2Marshaller marshaller(){
		 
	        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	        marshaller.setContextPath("ar.edu.ubp.das.rest.soap");
	        return marshaller;
	    }
	 
	  @Bean
	    public SoapClient getSoapClient(Jaxb2Marshaller marshaller){
	        SoapClient soapClient = new SoapClient();
	        System.out.println("PRIMER URL");
	        soapClient.setDefaultUri("http://localhost:8080/ServicioParcialWS/services/TiposServiciosWSPort/getTiposServicios");
	        System.out.println("FIN PRIMER URL");
	        soapClient.setMarshaller(marshaller);
	        soapClient.setUnmarshaller(marshaller);


	        return soapClient;
	    }
	 

}
