package ar.edu.ubp.das.rest.repository;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ubp.das.rest.beans.Sugerencia;
import ar.edu.ubp.das.rest.beans.Temas;
import ar.edu.ubp.das.rest.beans.Tipos;
import ar.edu.ubp.das.ws.jaxws.GetTiposServicios;
import ar.edu.ubp.das.ws.jaxws.GetTiposServiciosResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@SuppressWarnings("unused")
@Repository
public class TipoServicioRepository {
	

	@Autowired
	private JdbcTemplate jdbcTpl;


	@SuppressWarnings("unchecked")
	@Transactional
	public List<Temas> getTemas(String codigo) {
       	System.out.println(codigo);

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("cod_tipo_servicio", codigo);
        
    	SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
    	   .withProcedureName("get_temas_tipo_servicio")
           .withSchemaName("dbo")
       	   .returningResultSet("tipos_servicios", BeanPropertyRowMapper.newInstance(Temas.class));
       	
       	Map<String, Object> out = jdbcCall.execute(in);
       	System.out.println(out);
       	return (List<Temas>)out.get("tipos_servicios");
    }
	
	  @Transactional
	    public Sugerencia insServicio(Sugerencia data) {
	   
	        SqlParameterSource in = new MapSqlParameterSource()
	           .addValue("cod_tipo_servicio", data.getCodTipoServicio())
	           .addValue("nro_tema", data.getNumeroTema())
	           .addValue("sugerencia", data.getSugerencia());
	           	
	        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
	           .withProcedureName("ins_sugerencia")
	           .withSchemaName("dbo");
	        jdbcCall.execute(in);

	        return data;
	    }
	  
	  @SuppressWarnings("unchecked")
		public List<Tipos> getTipos() {
	    		        
//	    	SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
//	    	   .withProcedureName("get_tipos_servicios")
//	           .withSchemaName("dbo")
//	       	   .returningResultSet("tipos_servicios", BeanPropertyRowMapper.newInstance(Tipos.class));
//	       	
//	       	Map<String, Object> out = jdbcCall.execute();
//	       	return (List<Tipos>)out.get("tipos_servicios");
		  
		  GetTiposServicios request = new GetTiposServicios();


		    GetTiposServiciosResponse response = (GetTiposServiciosResponse) getWebServiceTemplate()
		        .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
		            new SoapActionCallback(
		                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		  
		  
	    }
	
}
