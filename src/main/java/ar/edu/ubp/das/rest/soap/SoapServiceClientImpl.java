package ar.edu.ubp.das.rest.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.edu.ubp.das.rest.beans.Tipos;

@WebService(targetNamespace = "http://ws.das.ubp.edu.ar/")
public interface SoapServiceClientImpl {
	@WebMethod(operationName = "getTiposServicios", action = "urn:GetTiposServicios")
    List<Tipos> getTiposServicios();
}
