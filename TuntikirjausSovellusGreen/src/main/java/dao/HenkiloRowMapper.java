package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import bean.Henkilo;

public class HenkiloRowMapper implements RowMapper<Henkilo> {

	public Henkilo mapRow(ResultSet rs, int rowNum) throws SQLException {
//		System.out.println("public Henkilo mapRow() luokassa HenkiloRowMapper.java aloitettu.");
		
		Henkilo h = new Henkilo();
		h.setHlo_tunnus(rs.getString("hlo_tunnus"));
		h.setHlo_etunimi(rs.getString("hlo_etunimi"));
		h.setHlo_sukunimi(rs.getString("hlo_sukunimi"));
	
		return h;
	}
	
}
