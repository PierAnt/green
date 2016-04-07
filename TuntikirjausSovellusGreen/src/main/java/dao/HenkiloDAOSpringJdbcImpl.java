package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.Henkilo;
import dao.HenkiloDAO;
import dao.HenkiloRowMapper;

public class HenkiloDAOSpringJdbcImpl  implements HenkiloDAO {

	
	private JdbcTemplate jdbcTemplate;	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	

//	public void talleta(Henkilo h) {
//
//		String sql = "insert into henkilo(hlo_tunnus, hlo_etunimi, hlo_sukunimi) values(?,?,?)";
//		Object[] parametrit = new Object[] { h.getHlo_tunnus(), h.getHlo_etunimi(), h.getHlo_sukunimi()};
//		jdbcTemplate.update(sql, parametrit);
//	}

	public void talleta(Henkilo h) {

		String sql = "insert into henkilo(hlo_tunnus, hlo_etunimi, hlo_sukunimi, hlo_k_tunnus, hlo_k_salasana, hlo_k_oikeudet) values(?,?,?,?,?,?)";
		Object[] parametrit = new Object[] { h.getHlo_tunnus(), h.getHlo_etunimi(), h.getHlo_sukunimi(), h.getHlo_k_tunnus(), h.getHlo_k_salasana(), h.getHlo_k_oikeudet()};
		jdbcTemplate.update(sql, parametrit);
	}

	public Henkilo etsi(int hlo_tunnus) {
		String sql = "select hlo_tunnus, hlo_etunimi, hlo_sukunimi, hlo_k_tunnus, hlo_k_salasana, hlo_k_oikeudet from henkilo where hlo_tunnus = ?";
		Object[] parametrit = new Object[] { hlo_tunnus };
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		Henkilo henkilo = jdbcTemplate.queryForObject(sql, parametrit, mapper);

		return henkilo;
	}
	
	// !!!!! ----- !!!!! ----- !!!!! ----- !!!!! ----- !!!!! ----- !!!!! -----
	// Rakensin super dorkasti (lue "ei ole tässä vaiheessa tarkotuskaan olla tietoturvallinen") -- Tuomas 5.4.2016
	// Salasanan vertaamisen pitäisi tapahtua serverin puolella.
	// Tämä toiminnallisuus toteutetaan myöhemmin uudestaan, ennalta rakennelluilla komponenteilla.
	public String haeHlo_k_salasana(int hlo_tunnus){
		//String sql = "select hlo_k_salasana from henkilo where hlo_tunnus = ?";
		String sql = "select hlo_tunnus, hlo_etunimi, hlo_sukunimi, hlo_k_tunnus, hlo_k_salasana, hlo_k_oikeudet from henkilo where hlo_tunnus = ?";
		Object[] parametrit = new Object[] { hlo_tunnus };
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		Henkilo henkilo = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		
		return henkilo.getHlo_k_salasana();
	}
	
	public List<Henkilo> haeHenkilot() {
		
		String sql = "select hlo_tunnus, hlo_etunimi, hlo_sukunimi, hlo_k_tunnus, hlo_k_salasana, hlo_k_oikeudet from henkilo";
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		List<Henkilo> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;
	}
}
