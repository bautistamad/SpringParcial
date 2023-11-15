package ar.edu.ubp.das.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.ubp.das.rest.beans.Sugerencia;
import ar.edu.ubp.das.rest.beans.Temas;
import ar.edu.ubp.das.rest.repository.SoapClient;
import ar.edu.ubp.das.rest.repository.TipoServicioRepository;
import ar.edu.ubp.das.rest.soap.GetTiposServiciosResponse;

@RestController
@RequestMapping(
  path="/api",
  produces={MediaType.APPLICATION_JSON_VALUE}
)

public class TipoServicioController {
	
    @Autowired
    TipoServicioRepository repository;
    @Autowired
    private SoapClient soapClient;
	
 
    @PostMapping(
        	path="/temas",
        	consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE}
        )
    
    	public ResponseEntity<List<Temas>>getTemas(String codTipoServicio) {
        	return new ResponseEntity<>(repository.getTemas(codTipoServicio), HttpStatus.OK);
    	}
    
    @PutMapping(path = "/sugerencia", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> insSugerencia(@RequestBody  Sugerencia sugerencia) {
        repository.insSugerencia(sugerencia);
        return ResponseEntity.ok().build();
    }
    
    

    @GetMapping("/tipos")
    public ResponseEntity<?> getTipos() {
    		System.out.println("ENTRA CONTROLLER");
//        AddResponse addResponse = soapClient.getAddResponse(numberA, numberB);
    	  GetTiposServiciosResponse response = soapClient.getTipos();
    	  System.out.print("RESPONSE: " +  response);
    	  System.out.println("RETURN CONTROLLER");
//        Map<String, Integer> response = new HashMap<>();
//        response.put("resultado", addResponse.getAddResult());
//        return ResponseEntity.ok().body(response);
    	  return null;
    }
    
    
    
 
}
