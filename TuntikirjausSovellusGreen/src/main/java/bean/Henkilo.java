package bean;

public class Henkilo {
	
	private int hlo_tunnus;
	private String hlo_etunimi;
	private String hlo_sukunimi;
	private String hlo_k_tunnus;
	private String hlo_k_salasana;
	private int hlo_k_oikeudet;
	
	public Henkilo(){
		this.hlo_tunnus = 0;
		this.hlo_etunimi = null;
		this.hlo_sukunimi = null;
		this.hlo_k_tunnus = null;
		this.hlo_k_salasana = null;
		this.hlo_k_oikeudet = 0;
	}
	
	public Henkilo(String hlo_k_salasana){
		this.hlo_k_salasana = hlo_k_salasana;
	}
		
	public Henkilo(int hlo_tunnus, String hlo_etunimi, String hlo_sukunimi) {
		super();
		this.hlo_tunnus = hlo_tunnus;
		this.hlo_etunimi = hlo_etunimi;
		this.hlo_sukunimi = hlo_sukunimi;
	}
	
	public Henkilo(int hlo_tunnus, String hlo_etunimi, String hlo_sukunimi, String hlo_k_tunnus, String hlo_k_salasana, int hlo_k_oikeudet) {
		super();
		this.hlo_tunnus = hlo_tunnus;
		this.hlo_etunimi = hlo_etunimi;
		this.hlo_sukunimi = hlo_sukunimi;
		this.hlo_k_tunnus = hlo_k_tunnus;
		this.hlo_k_salasana = hlo_k_salasana;
		this.hlo_k_oikeudet = hlo_k_oikeudet;
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
	public String getHlo_k_tunnus() {
		return hlo_k_tunnus;
	}
	public void setHlo_k_tunnus(String hlo_k_tunnus) {
		this.hlo_k_tunnus = hlo_k_tunnus;
	}
	public String getHlo_k_salasana() {
		return hlo_k_salasana;
	}
	public void setHlo_k_salasana(String hlo_k_salasana) {
		this.hlo_k_salasana = hlo_k_salasana;
	}
	public int getHlo_k_oikeudet() {
		return hlo_k_oikeudet;
	}
	public void setHlo_k_oikeudet(int hlo_k_oikeudet) {
		this.hlo_k_oikeudet = hlo_k_oikeudet;
	}
	@Override
	public String toString() {
		return "Henkilo [hlo_tunnus=" + hlo_tunnus + ", hlo_etunimi="
				+ hlo_etunimi + ", hlo_sukunimi=" + hlo_sukunimi
				+ ", hlo_k_tunnus=" + hlo_k_tunnus + ", hlo_k_salasana="
				+ hlo_k_salasana + ", hlo_k_oikeudet=" + hlo_k_oikeudet + "]";
	}
	



}

