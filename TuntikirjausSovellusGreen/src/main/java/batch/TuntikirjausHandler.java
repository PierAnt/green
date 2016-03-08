package batch;

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
		
//		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!   | hlo_id | hlo_etunimi | hlo_sukunimi | hlo_tunnit | hlo_pvm             |!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
		TuntikirjausDAO tuntikirjausDao = (TuntikirjausDAO)context.getBean("tuntikirjausDaoLuokka");
		HenkiloDAO henkiloDao = (HenkiloDAO)context.getBean("henkiloDaoLuokka");
	
		Scanner input = new Scanner(System.in);
		Kayttaja kayttaja = new Kayttaja();
		
		
		boolean ajetaan = true;

		
		while (ajetaan) {
			int valinta;
			
			System.out.println("Käyttäjä: " + kayttaja.toString());
			
			System.out.println("Vaihtoehdot:\n"
					+ "1. Näytä kaikki henkilöt\n"
					+ "2. Valitse henkilö jona haluat tehdä kirjauksen (Ei vielä käytössä)\n"
					+ "3. Lisää henkilö tuntiseurattavien piiriin (Testikäytössä - muuttuu epävakaammaksi jokaisella lisäyksellä tauluun,\n"
					+ "koska hlo_tunnus muodostuu satunnaisnumerosta 0-10000 ja saman arpoutuminen kaataa ohjelman)\n"
					+ "4. Näytä kaikki tuntikirjaukset\n"
					+ "5. Tee tuntikirjaus (Ei vielä käytössä)\n"
					+ "6. Poistu\n"
					
					+ "Valinta: ");
			
			valinta = input.nextInt();
			
			switch (valinta)
			{
			case 1:
				System.out.println("-------------------");
				System.out.println("LISTATAAN KAIKKI HENKILÖT");
				System.out.println("-------------------");
				
				List<Henkilo> henkilot = henkiloDao.haeHenkilot();
				for (Henkilo h : henkilot) {
					System.out.println("Henkilon tunnus : " + h.getHlo_tunnus());
					System.out.println("Henkilon etunimi : " + h.getHlo_etunimi());
					System.out.println("Henkilon sukunimi : " + h.getHlo_sukunimi() + "\n");
				}
				break;
			
			case 2:
				break;
			
			case 3:
				System.out.println("-------------------");
				System.out.println("Lisää henkilö tuntiseurattavien piiriin");
				System.out.println("-------------------");
				
				String etunimi;
				String sukunimi;
				
				System.out.print("Anna etunimi:");
				input.nextLine();
				etunimi = input.nextLine();
				System.out.print("Anna sukunimi:");
				sukunimi = input.nextLine();
				System.out.println("");
				Henkilo henkilo = new Henkilo(etunimi, sukunimi);
				henkiloDao.talleta(henkilo);
				
				break;
				
			case 4:
				System.out.println("-------------------");
				System.out.println("LISTATAAN KAIKKI TUNTIKIRJAUKSET");
				System.out.println("-------------------");
				
				List<Tuntikirjaus> tuntikirjaukset= tuntikirjausDao.haeKaikki();
				for (Tuntikirjaus tk : tuntikirjaukset) {
					System.out.println("Tuntikirjaus ID : " + tk.getTuntikirjaus_id());
					System.out.println("Henkilon tunnus : " + tk.getHlo_tunnus());
					System.out.println("Tyon selite : " + tk.getSelite());
					System.out.println("Tehty tuntimaara : " + tk.getTuntimaara());
					System.out.println("Paivamaara jolloin tyo tehtiin : " + tk.getPvm() + "\n");
				}
				break;			
			case 5:
				String kirjaajaEtunimi;
				String kirjaajaSukunimi;
				int tunnit;
								
				String hlo_id = "0";
				String hlo_pvm = "";
				
				System.out.println("Anna kirjaajan etunimi");
				input.nextLine();
				kirjaajaEtunimi = input.nextLine();
				
				
				System.out.println("Anna kirjaajan sukunimi");
				kirjaajaSukunimi = input.nextLine();
								
				System.out.println("Montako tuntia tuli tehtyä?");
				tunnit = input.nextInt();
								
				Tuntikirjaus uusiTuntikirjaus = new Tuntikirjaus(kirjaajaEtunimi, kirjaajaSukunimi, tunnit);
				tuntikirjausDao.talleta(uusiTuntikirjaus);
				
//				INSERT INTO henkilo(hlo_id, hlo_etunimi, hlo_sukunimi, hlo_tunnit)
//				VALUES ('0','Sven','Jorgenseen',11);
								
				break;			
			case 6:
				ajetaan = false;
				break;
			}
		}
					
		input.close();
		context.close();

	}

}