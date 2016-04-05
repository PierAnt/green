package batch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Tuntikirjaus;
import bean.Henkilo;
import dao.TuntikirjausDAO;
import dao.HenkiloDAO;
import bean.Kayttaja;

import java.util.Scanner;

public class TuntikirjausHandler {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		TuntikirjausDAO tuntikirjausDao = (TuntikirjausDAO)context.getBean("tuntikirjausDaoLuokka");
		HenkiloDAO henkiloDao = (HenkiloDAO)context.getBean("henkiloDaoLuokka");
	
		Scanner input = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Kayttaja kayttaja = null;
		Henkilo henkilo;
		String selite;
		String hlo_k_salasana;
		String salasanaSyotetty;
		String muotoiltu_pvm;
		String etunimi;
		String sukunimi;
		String hlo_k_tunnus;
		int  hlo_k_oikeudet;
		int hlo_tunnus;
		int tunnit;
		
		boolean ajetaan = true;

		while (ajetaan) {
			int valinta;			
			
			if (kayttaja != null){
				System.out.println("\nVaihtoehdot k�ytt�j�lle " + kayttaja.getHlo_etunimi() + " " + kayttaja.getHlo_sukunimi() + "\n");}
			else{
				System.out.println("\nVaihtoehdot:\n");
			}
					
			System.out.println("" 
					+ "0. Kirjaudu sis��n 					TOIMII\n"
					+ "1. N�yt� kaikki henkil�t 				TOIMII\n"
					+ "2. Muokkaa henkil�� (admin) 				(Ei viel� k�yt�ss�)\n"
					+ "3. Tee oma tuntikirjaus 				TOIMII\n"
					+ "4. Lis�� henkil� tuntiseurattavien piiriin (admin)	TOIMII\n"
					+ "5. N�yt� omat tuntikirjaukset 				TOIMII\n"
					+ "6. N�yt� kaikki tuntikirjaukset (admin)			TOIMII\n"
					+ "7. Tee tuntikirjaus kenelle tahansa (admin) 		TOIMII\n"
					+ "8. Kirjaudu ulos					TOIMII\n"
					+ "9. Sulje ohjelma					TOIMII\n\n"
					
					+ "Valinta: ");
			
			valinta = input.nextInt();
			
			switch (valinta)
			{
			
			// Kirjaudu sis��n  -- Kysyys hlo_tunnuksen ja salasanan ja vertaa niit� toisiinsa.
			// Jos oikein, luo uuden k�ytt�j�n t�st� henkil�st�.
			case 0:
				System.out.println("Anna hlo_tunnus: ");
				hlo_tunnus = input.nextInt();
				henkilo  = henkiloDao.etsi(hlo_tunnus);
				input.nextLine();
				System.out.println("Anna salasana: ");
				salasanaSyotetty = input.nextLine();			
				hlo_k_salasana = henkiloDao.haeHlo_k_salasana(hlo_tunnus);
							
				if (salasanaSyotetty.matches(hlo_k_salasana)){
					kayttaja = new Kayttaja(henkilo.getHlo_tunnus(), henkilo.getHlo_etunimi(), henkilo.getHlo_sukunimi(), henkilo.getHlo_k_tunnus(), henkilo.getHlo_k_oikeudet());
					System.out.println("Tervetuloa " + kayttaja.getHlo_etunimi() + " " + kayttaja.getHlo_sukunimi() + ".");
				}
				else {
					System.out.println("K�ytt�j�tunnus tai salasana virheellinen!");
					System.out.println("Unohditko salasanasi?");
				}
				break;
			
			//N�yt� kaikki henkil�t
			case 1:
				System.out.println("-------------------");
				System.out.println("LISTATAAN KAIKKI HENKIL�T");
				System.out.println("-------------------\n");
				
				List<Henkilo> henkilot = henkiloDao.haeHenkilot();
				for (Henkilo h : henkilot) {
					System.out.println(""
							+ "Henkilon tunnus: " + h.getHlo_tunnus() 
							+ "		Henkilon etunimi: " + h.getHlo_etunimi() 
							+ "		Henkilon sukunimi: " + h.getHlo_sukunimi());
				}
				System.out.println();
				break;
			
			//Muokkaa henkil�� (admin)
			case 2:
				System.out.println("T�h�n tulee toiminnallisuus jossa admin k�ytt�j� voi muokata mink� tahansa henkil�n ominaisuuksia");
				System.out.println("Toiminnallisuudet jotka t�nne pit�� saada:");
				System.out.println("1.Valitse muokattava henkil�.");
				System.out.println("2.Vaihda henkil�n etunimi");
				System.out.println("3.Vaihda henkil�n sukunimi");
				System.out.println("4.Vaihda hlo_k_tunnus");
				System.out.println("5.Vaihda hlo_k_salasana");
				System.out.println("6.Vaihda hlo_k_oikeudet");
				
				if (kayttaja != null && kayttaja.getHlo_k_oikeudet() >= 1){
					do{
						switch (valinta){
						case 1:
							System.out.println("Anna henkil�n hlo_tunnus jota haluat muokata: ");
							break;
						case 2:
							System.out.println("Anna henkil�n uusi etunimi");
							break;
						case 3:
							System.out.println("Anna henkil�n uusi sukunimi");
							break;
						case 4:
							System.out.println("Anna henkilon uusi hlo_k_tunnus");
							break;
						case 5:
							System.out.println("Anna henkil�n uusi hlo_k_salasana");
							break;
						case 6:
							System.out.println("Anna henkil�n uusi hlo_k_oikeudet");
							break;
						case 7:
							break;
						}
					}while(valinta != 7);
				}
				break;
				
			//Tee oma tuntikirjaus
			case 3:
				System.out.println("T�h�n tulee toiminnallisuus jossa kirjautunut henkil� voi tehd� itselleen tuntikirjauksen");
				
				if (kayttaja != null && kayttaja.getHlo_k_oikeudet() >= 0){
					System.out.println("Anna kirjaukseen liittyv� selite");
					input.nextLine();
					selite = input.nextLine();
					System.out.println("Montako tuntia tuli tehty�?");
					tunnit = input.nextInt();
					muotoiltu_pvm = dateFormat.format(new Date());
					Tuntikirjaus uusiTuntikirjaus = new Tuntikirjaus(0, kayttaja.getHlo_tunnus(), selite, tunnit, muotoiltu_pvm);
					tuntikirjausDao.talleta(uusiTuntikirjaus);
				}
				break;
			
			//Lis�� henkil� tuntiseurattavien piiriin (admin)
			case 4:
				if (kayttaja != null && kayttaja.getHlo_k_oikeudet() >= 1){
					System.out.println("-------------------");
					System.out.println("Lis�� henkil� tuntiseurattavien piiriin");
					System.out.println("-------------------\n");
					
					int tunnus = 0;
					System.out.print("Anna etunimi:");
					input.nextLine();
					etunimi = input.nextLine();
					System.out.print("Anna sukunimi:");
					sukunimi = input.nextLine();
					System.out.println("Anna hlo_k_tunnus");
					hlo_k_tunnus = input.nextLine();
					System.out.println("hlo_k_salasana");
					hlo_k_salasana = input.nextLine();
					System.out.println("hlo_k_oikeudet");
					hlo_k_oikeudet = input.nextInt();
					input.nextLine();
					henkilo = new Henkilo(tunnus, etunimi, sukunimi, hlo_k_tunnus, hlo_k_salasana, hlo_k_oikeudet);
					henkiloDao.talleta(henkilo);
				}
				else{
					System.out.println("K�yt�ikeutesi eiv�t riit� henkil�n lis��miseen tuntiseurattavien piirin");
				}
				break;
			
			//N�yt� omat tuntikirjaukset
			case 5:
				System.out.println("T�h�n tulee toiminnallisuus n�yt� omat tuntikirjaukset (Ty�n alla)\n");
				
				if (kayttaja == null){
					System.out.println("Et ole kirjautunut sis��n. Kirjaudu sis��n jotta voit n�hd� tuntikirjauksesi.");
				}
				else{
					System.out.println("N�ytet��n kaikki k�ytt�j�n " + kayttaja.getHlo_etunimi() + " " + kayttaja.getHlo_sukunimi() + " kirjaukset.\n");
					
					List<Tuntikirjaus> tuntikirjaukset= tuntikirjausDao.haeHenkilonKirjaukset(kayttaja.getHlo_tunnus());
					for (Tuntikirjaus tk : tuntikirjaukset) {
						System.out.println(""
								+ "Tuntikirjaus ID: " + tk.getTuntikirjaus_id() 
								+ "		Henkilon tunnus: " + tk.getHlo_tunnus()
								+ "		Tyon selite: " + tk.getSelite() 
								+ "		Tehty tuntimaara: " + tk.getTuntimaara()
								+ "		Paivamaara jolloin tyo tehtiin: " + tk.getPvm());
					}
					System.out.println();
				}
				break;
				
			//N�yt� kaikki tuntikirjaukset (admin)
			case 6:
				if (kayttaja != null && kayttaja.getHlo_k_oikeudet() >= 1){
					System.out.println("-------------------");
					System.out.println("N�YTET��N KAIKKI TUNTIKIRJAUKSET");
					System.out.println("-------------------\n");
					
					List<Tuntikirjaus> tuntikirjaukset= tuntikirjausDao.haeKaikki();
					for (Tuntikirjaus tk : tuntikirjaukset) {
						System.out.println(""
								+ "Tuntikirjaus ID: " + tk.getTuntikirjaus_id() 
								+ "		Henkilon tunnus: " + tk.getHlo_tunnus()
								+ "		Tyon selite: " + tk.getSelite() 
								+ "		Tehty tuntimaara: " + tk.getTuntimaara()
								+ "		Paivamaara jolloin tyo tehtiin: " + tk.getPvm());
					}
					System.out.println();	
				}
				else{
					System.out.println("Sinulla ei ole vaadittavia k�ytt�oikeuksia kaikkien tuntikirjausten katselemiseen");
				}				
				break;			
			
			//Tee tuntikirjaus kenelle tahansa (admin)
			case 7:
				if (kayttaja != null && kayttaja.getHlo_k_oikeudet() >= 1){
					int kirjaajaHlo_tunnus;
					
					String hlo_pvm = dateFormat.format(new Date());
					System.out.println(hlo_pvm);
					
					System.out.println("Kenen tunnit kyseess�? Anna hlo_tunnus:");
					input.nextLine();
					kirjaajaHlo_tunnus = input.nextInt();
					
					System.out.println("Anna kirjaukseen liittyv� selite");
					input.nextLine();
					selite = input.nextLine();
									
					System.out.println("Montako tuntia tuli tehty�?");
					tunnit = input.nextInt();
									
					Tuntikirjaus uusiTuntikirjaus = new Tuntikirjaus(0, kirjaajaHlo_tunnus, selite, tunnit, hlo_pvm);
					tuntikirjausDao.talleta(uusiTuntikirjaus);
				}
				else {
					System.out.println("K�ytt�oikeutesi eiv�t riit� tuntikirjauksen tekemiseen muulle kuin itsellesi");
				}
				break;			
			
			//Kirjaudu ulos  -- K�ytt�j� kirjautuu ulos.			
			case 8:
				System.out.println(kayttaja.getHlo_etunimi() + " " + kayttaja.getHlo_sukunimi() + " on kirjautunut ulos.");
				kayttaja = null;
				break;
			
			//Sulje ohjelma
			case 9:
				ajetaan = false;
				break;
			}
		}
		input.close();
		context.close();
	}
}