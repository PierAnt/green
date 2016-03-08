package bean;

import java.lang.Math;

public class Henkilo {
	
	private String hlo_tunnus;
	private String hlo_etunimi;
	private String hlo_sukunimi;
	
	public Henkilo(){
	}
	
	
	// HUOMIO HUOMIO HUOMI !!!!!!!!!
	// HUOMIO HUOMIO HUOMI !!!!!!!!!
	// HUOMIO HUOMIO HUOMI !!!!!!!!!
	// TÄSSÄ METODISSA ON KÄYTETTY VIHOVIIMEISTÄ KIERTOKIKKAA KOHDASSA this.hlo_tunnus = Integer.toString((int) Math.floor(Math.random() * 10000));
	public Henkilo(String hlo_etunimi, String hlo_sukunimi) {
		super();
		this.hlo_tunnus = Integer.toString((int) Math.floor(Math.random() * 10000));
		this.hlo_etunimi = hlo_etunimi;
		this.hlo_sukunimi = hlo_sukunimi;
	}

	
	
	
	public Henkilo(String hlo_tunnus, String hlo_etunimi, String hlo_sukunimi) {
		super();
		this.hlo_tunnus = hlo_tunnus;
		this.hlo_etunimi = hlo_etunimi;
		this.hlo_sukunimi = hlo_sukunimi;
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
	
	public String getHlo_tunnus() {
		return hlo_tunnus;
	}

	public void setHlo_tunnus(String hlo_tunnus) {
		this.hlo_tunnus = hlo_tunnus;
	}


}

