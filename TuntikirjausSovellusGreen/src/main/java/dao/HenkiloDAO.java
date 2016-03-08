package dao;

import java.util.List;
import bean.Henkilo;

public interface HenkiloDAO {

	public abstract void talleta(Henkilo henkilo);

	public abstract List<Henkilo> haeHenkilot();

}
