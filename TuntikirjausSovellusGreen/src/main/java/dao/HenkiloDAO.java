package dao;

import java.util.List;
import bean.Henkilo;

public interface HenkiloDAO {

	public abstract void talleta(Henkilo henkilo);
	
	public abstract Henkilo etsi(int hlo_tunnus);
	
	public abstract String haeHlo_k_salasana(int hlo_tunnus);

	public abstract List<Henkilo> haeHenkilot();

}
