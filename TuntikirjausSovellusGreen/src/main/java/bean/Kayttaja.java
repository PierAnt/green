package bean;

public class Kayttaja {
	
	private String hlo_tunnus;
	private String hlo_etunimi;
	private String hlo_sukunimi;

	public void kayttaja(){
		hlo_tunnus = "ei tunnusta";
		hlo_etunimi = "ei etunimeä";
		hlo_sukunimi = "ei sukunimeä";
	}
	
	public void kayttaja(String hlo_tunnus, String hlo_etunimi, String hlo_sukunimi){
		this.hlo_tunnus = hlo_tunnus;
		this.hlo_etunimi = hlo_etunimi;
		this.hlo_sukunimi = hlo_sukunimi;
	}
	
	public String toString(){
		String kayttaja = "etunimi: " + hlo_etunimi + "sukunimi: " + hlo_sukunimi + "käyttäjätunnus: " + hlo_tunnus;
		return kayttaja;
	}
	
	
	
	
	
	
}
