package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import bean.Henkilo;

public class HenkiloRowMapper implements RowMapper<Henkilo> {

	public Henkilo mapRow(ResultSet rs, int rowNum) throws SQLException {
//		System.out.println("public Henkilo mapRow() luokassa HenkiloRowMapper.java aloitettu.");
		
		Henkilo h = new Henkilo();
		h.setHlo_tunnus(rs.getInt("hlo_tunnus"));
		h.setHlo_etunimi(rs.getString("hlo_etunimi"));
		h.setHlo_sukunimi(rs.getString("hlo_sukunimi"));
//		Kun otat n�m� k�ytt��n, huomio niiden j�rjestys samaksi miss� ne esiintyy tietokantataulussa (sill� saattaa olla merkityst�).
		h.setHlo_k_tunnus(rs.getString("hlo_k_tunnus"));
		h.setHlo_k_salasana(rs.getString("hlo_k_salasana"));
		h.setHlo_k_oikeudet(rs.getInt("hlo_k_oikeudet"));
		
		return h;
	}
	
}
