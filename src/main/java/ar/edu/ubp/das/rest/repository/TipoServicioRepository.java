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
	    public Sugerencia insSugerencia(Sugerencia data) {
	   
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
	
}
