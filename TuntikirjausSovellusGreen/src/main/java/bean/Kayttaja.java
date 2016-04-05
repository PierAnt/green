package bean;

public class Kayttaja {
	
	private int hlo_tunnus;
	private String hlo_etunimi;
	private String hlo_sukunimi;

	public Kayttaja(){
		this.hlo_tunnus = 0;
		this.hlo_etunimi = null;
		this.hlo_sukunimi = null;
	}
	
	public Kayttaja(int hlo_tunnus, String hlo_etunimi, String hlo_sukunimi){
		this.hlo_tunnus = hlo_tunnus;
		this.hlo_etunimi = hlo_etunimi;
		this.hlo_sukunimi = hlo_sukunimi;
	}
	
	
	public int getHlo_tunnus() {
		return hlo_tunnus;
	}

	public void setHlo_tunnus(int hlo_tunnus) {
		this.hlo_tunnus = hlo_tunnus;
	}

	public String getHlo_etunimi() {
		return hlo_etunimi;
	}

	public void setHlo_etunimi(String hlo_etunimi) {
		this.hlo_etunimi = hlo_etunimi;
	}

	public String getHlo_sukunimi() {
		return hlo_sukunimi;
	}

	public void setHlo_sukunimi(String hlo_sukunimi) {
		this.hlo_sukunimi = hlo_sukunimi;
	}

	@Override
	public String toString() {
		return "Kayttaja [hlo_tunnus=" + hlo_tunnus + ", hlo_etunimi="
				+ hlo_etunimi + ", hlo_sukunimi=" + hlo_sukunimi + "]";
	}
	
	
	
	
	
	
}
