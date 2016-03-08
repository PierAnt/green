package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import bean.Tuntikirjaus;

public class TuntikirjausRowMapper implements RowMapper<Tuntikirjaus> {

	public Tuntikirjaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tuntikirjaus tk = new Tuntikirjaus();
		tk.setTuntikirjaus_id(rs.getString("tuntikirjaus_id"));
		tk.setHlo_tunnus(rs.getString("hlo_tunnus"));
		tk.setSelite(rs.getString("selite"));
		tk.setTuntimaara(rs.getInt("tuntimaara"));
		tk.setPvm(rs.getString("pvm"));
		return tk;
	}
}
