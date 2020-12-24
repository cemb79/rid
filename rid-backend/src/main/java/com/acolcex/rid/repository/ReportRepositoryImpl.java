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
import com.acolcex.rid.model.dto.DeliveryOrderStatusDTO;

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
		String sql = "select do.codPuerto as port,\n"
				+ "          case when len(ltrim(rtrim(p.NombreSucursal))) = 0 then 'Desconocido' else ltrim(rtrim(p.NombreSucursal)) end as port_name,\n"
				+ "	         count(do.codPuerto) as num_do\n"
				+ "   from do,\n"
				+ "	    usuariosRid u,\n"
				+ "	    Sucursal p\n"
				+ "  where do.codCliente = u.UsuarioID\n"
				+ "	and u.UsuarioID = ?\n"
				+ "	and do.codSucursal = p.CodSucursal\n"
				+ "	and do.codEstadoDO = 'ACT'\n"
				+ "  group by do.codPuerto, p.NombreSucursal";
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
	
	@Override
	public List<DeliveryOrderStatusDTO> getDeliveryOrderStatusCount(String userId) {
		String sql = "select s.CodEstadoDO, s.NombreEstadoDO ,count(s.CodEstadoDO) as numStatus\n"
				+ "  from do,\n"
				+ "       estadoDO s\n"
				+ " where do.codCliente = ?\n"
				+ "   and do.CodEstadoDO = s.CodEstadoDO \n"
				+ " group by s.CodEstadoDO, s.NombreEstadoDO";
		Object[] args = new Object[1];
		args[0] = userId;
		logger.debug("SQL: {}", sql);
		return jdbcTemplate.query(sql, args, new RowMapper<DeliveryOrderStatusDTO>() {

			@Override
			public DeliveryOrderStatusDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeliveryOrderStatusDTO(rs.getString("CodEstadoDO"), rs.getString("NombreEstadoDO"), rs.getInt("numStatus"));
			}
			
		});
	}

}
