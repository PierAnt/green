package dao;

import java.util.List;
import bean.Tuntikirjaus;

public interface TuntikirjausDAO {

	public abstract void talleta(Tuntikirjaus tuntikirjaus);
	
	public abstract List<Tuntikirjaus> haeHenkilonKirjaukset(int hlo_tunnus);
	
	public abstract List<Tuntikirjaus> haeKaikki();


}
