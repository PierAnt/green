package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.Tuntikirjaus;
import dao.TuntikirjausDAO;
import dao.TuntikirjausRowMapper;

public class TuntikirjausDAOSpringJdbcImpl implements TuntikirjausDAO {

	
	private JdbcTemplate jdbcTemplate;	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	

	public void talleta(Tuntikirjaus tk) {

		String sql = "insert into tuntikirjaus(hlo_tunnus, selite, tuntimaara, pvm) values(?,?,?,?)";
		Object[] parametrit = new Object[] { tk.getHlo_tunnus(), tk.getSelite(), tk.getTuntimaara(), tk.getPvm() };
		jdbcTemplate.update(sql, parametrit);
	}

	public Tuntikirjaus etsi(int hlo_tunnus) {
		String sql = "select tuntikirjaus_id, hlo_tunnus, hlo_selite, tuntimaara, pvm from tuntikirjaus where tuntikirjaus_id = ?";
		Object[] parametrit = new Object[] { hlo_tunnus };
		RowMapper<Tuntikirjaus> mapper = new TuntikirjausRowMapper();

		Tuntikirjaus tk = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return tk;

	}
	
	public List<Tuntikirjaus> haeKaikki() {
		
		String sql = "select tuntikirjaus_id, hlo_tunnus, selite, tuntimaara, pvm from tuntikirjaus";
		RowMapper<Tuntikirjaus> mapper = new TuntikirjausRowMapper();
		List<Tuntikirjaus> tuntikirjaukset = jdbcTemplate.query(sql, mapper);

		return tuntikirjaukset;
	}
//	
//	public List<Henkilo> haeHenkilot() {
//		
//		String sql = "select hlo_tunnus, hlo_etunimi, hlo_sukunimi from henkilo";
//		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
//		List<Henkilo> henkilot = jdbcTemplate.query(sql, mapper);
//
//		return henkilot;
//	}
}
