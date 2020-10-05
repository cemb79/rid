package com.acolcex.rid.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

	private static final Logger logger = LoggerFactory.getLogger(ReportRepositoryImpl.class);

    private JdbcTemplate jdbcTemplate;

	public ReportRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
    
	@Override
	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId) {
		String sql = "select do.codPuerto as port, \r\n" + 
				"	   case when len(ltrim(rtrim(nombrePuerto))) = 0 then 'Desconocido' else ltrim(rtrim(nombrePuerto)) end as port_name, \r\n" + 
				"	   count(do.codPuerto) as num_do\r\n" + 
				"  from do,\r\n" + 
				"       usuariosRid u,\r\n" + 
				"       Puertos p\r\n" + 
				" where do.codCliente = u.UsuarioID\r\n" + 
				"   and u.UsuarioID = ?\r\n" + 
				"   and do.codPuerto = p.CodPuerto\r\n" + 
				" group by do.codPuerto, p.NombrePuerto";
		Object[] args = new Object[1];
		args[0] = userId;
		logger.debug("SQL: {}", sql);
		return jdbcTemplate.query(sql, args, new RowMapper<DeliveryOrderCityDTO>() {

			@Override
			public DeliveryOrderCityDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeliveryOrderCityDTO(rs.getString("port"), rs.getString("port_name"), rs.getInt("num_do"));
			}
			
		});
	}

}
