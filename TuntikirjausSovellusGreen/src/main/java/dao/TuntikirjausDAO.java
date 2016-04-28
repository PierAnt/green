package dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.Tuntikirjaus;

public class TuntikirjausDAO {
	
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
	
	public ArrayList<Tuntikirjaus> haeHenkilonKirjaukset(int hlo_tunnus) {
		String sql = "select tuntikirjaus_id, hlo_tunnus, selite, tuntimaara, pvm from tuntikirjaus where hlo_tunnus = ?";
		Object[] parametrit = new Object[] { hlo_tunnus };
		RowMapper<Tuntikirjaus> mapper = new TuntikirjausRowMapper();

		ArrayList<Tuntikirjaus> tk = (ArrayList<Tuntikirjaus>) jdbcTemplate.query(sql, parametrit, mapper);
		return tk;

	}
	
	public Tuntikirjaus etsi(int hlo_tunnus) {
		String sql = "select tuntikirjaus_id, hlo_tunnus, hlo_selite, tuntimaara, pvm from tuntikirjaus where hlo_tunnus = ?";
		Object[] parametrit = new Object[] { hlo_tunnus };
		RowMapper<Tuntikirjaus> mapper = new TuntikirjausRowMapper();

		Tuntikirjaus tk = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return tk;

	}
	
	public ArrayList<Tuntikirjaus> haeKaikki() {
		
		String sql = "select tuntikirjaus_id, hlo_tunnus, selite, tuntimaara, pvm from tuntikirjaus";
		RowMapper<Tuntikirjaus> mapper = new TuntikirjausRowMapper();
		ArrayList<Tuntikirjaus> tuntikirjaukset = (ArrayList<Tuntikirjaus>) jdbcTemplate.query(sql, mapper);

		return tuntikirjaukset;
	}


}
