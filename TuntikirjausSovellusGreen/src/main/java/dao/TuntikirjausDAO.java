package dao;

import java.util.List;
import bean.Tuntikirjaus;

public interface TuntikirjausDAO {

	public abstract void talleta(Tuntikirjaus tuntikirjaus);
	
	public abstract List<Tuntikirjaus> haeKaikki();


}
