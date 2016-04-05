package bean;

public class Tuntikirjaus {
	
	private String tuntikirjaus_id;
	private int hlo_tunnus;
	private String selite;
	private int tuntimaara;
	private String pvm;

	public Tuntikirjaus(){
	}
	
	public Tuntikirjaus(int tuntikirjaus_id, int hlo_tunnus, String selite, int tuntimaara, String pvm) {
		super();
		this.tuntikirjaus_id = "0";
		this.hlo_tunnus = hlo_tunnus;
		this.selite = selite;
		this.tuntimaara = tuntimaara;
		this.pvm = pvm;
	}

	public String getTuntikirjaus_id() {
		return tuntikirjaus_id;
	}

	public void setTuntikirjaus_id(String tuntikirjaus_id) {
		this.tuntikirjaus_id = tuntikirjaus_id;
	}

	public int getHlo_tunnus() {
		return hlo_tunnus;
	}

	public void setHlo_tunnus(int hlo_tunnus) {
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

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}
	
}
