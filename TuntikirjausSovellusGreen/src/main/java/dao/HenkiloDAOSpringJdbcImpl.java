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

	public void talleta(Henkilo h) {

		String sql = "insert into henkilo(hlo_tunnus, hlo_etunimi, hlo_sukunimi) values(?,?,?)";
		Object[] parametrit = new Object[] { h.getHlo_tunnus(), h.getHlo_etunimi(), h.getHlo_sukunimi()};
		jdbcTemplate.update(sql, parametrit);
	}

	public Henkilo etsi(int hlo_tunnus) {
		String sql = "select hlo_tunnus, hlo_etunimi, hlo_sukunimi from henkilo where henkilo_tunnus = ?";
		Object[] parametrit = new Object[] { hlo_tunnus };   // Tällä rivillä on tod.näk. vikaa. --- Oletan että kohdassa { hlo_tunnus };
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		Henkilo henkilo = jdbcTemplate.queryForObject(sql, parametrit, mapper);

		return henkilo;
	}
	
	public List<Henkilo> haeHenkilot() {
		
		String sql = "select hlo_tunnus, hlo_etunimi, hlo_sukunimi from henkilo";
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		List<Henkilo> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;
	}
}
