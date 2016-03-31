package bean;

import java.util.Date;

public class Tuntikirjaus {
	
	private String tuntikirjaus_id;
	private String hlo_tunnus;
	private String selite;
	private int tuntimaara;
	private Date pvm;

	public Tuntikirjaus(){
	}
	
	public Tuntikirjaus(String hlo_tunnus, String selite, int tuntimaara, Date pvm) {
		super();
		this.tuntikirjaus_id = "0";
		this.hlo_tunnus = hlo_tunnus;
		this.selite = selite;
		this.tuntimaara = tuntimaara;
		this.pvm = pvm;  // <------- voi olla ettei tätä kuulu syöttää ollenkaan???!!!
	}
	public String getTuntikirjaus_id() {
		return tuntikirjaus_id;
	}

	public void setTuntikirjaus_id(String tuntikirjaus_id) {
		this.tuntikirjaus_id = tuntikirjaus_id;
	}

	public String getHlo_tunnus() {
		return hlo_tunnus;
	}

	public void setHlo_tunnus(String hlo_tunnus) {
		this.hlo_tunnus = hlo_tunnus;
	}

	public String getSelite() {
		return selite;
	}

	public void setSelite(String selite) {
		this.selite = selite;
	}

	public int getTuntimaara() {
		return tuntimaara;
	}

	public void setTuntimaara(int tuntimaara) {
		this.tuntimaara = tuntimaara;
	}

	public Date getPvm() {
		return pvm;
	}

	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}
	
}
