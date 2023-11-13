package ar.edu.ubp.das.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.ubp.das.rest.beans.Sugerencia;
import ar.edu.ubp.das.rest.beans.TemasTipoServicio;
import ar.edu.ubp.das.rest.repository.TipoServicioRepository;

@RestController
@RequestMapping(
  path="/api/sugerencias",
  produces={MediaType.APPLICATION_JSON_VALUE}
)

public class TipoServicioController {
	
    @Autowired
    TipoServicioRepository repository;
	
 
    @PostMapping(
        	path="/temas",
        	consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE}
        )
    
    	public ResponseEntity<List<TemasTipoServicio>>getTiposServicios(String codTipoServicio) {
        	return new ResponseEntity<>(repository.getTiposServicios(codTipoServicio), HttpStatus.OK);
    	}
    
    @PutMapping(path = "/sugerencia", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> insSugerencia(@RequestBody  Sugerencia sugerencia) {
        repository.insServicio(sugerencia);
        return ResponseEntity.ok().build();
    }
    
    
    
 
}
