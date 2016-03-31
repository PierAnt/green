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
		
//		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!   | hlo_id | hlo_etunimi | hlo_sukunimi | hlo_tunnit | hlo_pvm             |!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
		TuntikirjausDAO tuntikirjausDao = (TuntikirjausDAO)context.getBean("tuntikirjausDaoLuokka");
		HenkiloDAO henkiloDao = (HenkiloDAO)context.getBean("henkiloDaoLuokka");
	
		Scanner input = new Scanner(System.in);
		Kayttaja kayttaja = new Kayttaja();
		
		
		boolean ajetaan = true;

		
		while (ajetaan) {
			int valinta;
			
			//System.out.println("Käyttäjä: " + kayttaja.toString());
			
			System.out.println("\nVaihtoehdot:\n"
					+ "1. Näytä kaikki henkilöt\n"
					+ "2. Valitse henkilö jona haluat tehdä kirjauksen (Ei vielä käytössä)\n"
					+ "3. Lisää henkilö tuntiseurattavien piiriin\n"
					+ "4. Näytä kaikki tuntikirjaukset\n"
					+ "5. Tee tuntikirjaus\n"
					+ "6. Poistu\n"
					
					+ "Valinta: ");
			
			valinta = input.nextInt();
			
			switch (valinta)
			{
			case 1:
				System.out.println("-------------------");
				System.out.println("LISTATAAN KAIKKI HENKILÖT");
				System.out.println("-------------------\n");
				
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
				System.out.println("-------------------\n");
				
				int tunnus = 0;
				String etunimi;
				String sukunimi;
				
				System.out.print("Anna etunimi:");
				input.nextLine();
				etunimi = input.nextLine();
				System.out.print("Anna sukunimi:");
				sukunimi = input.nextLine();
				System.out.println("");
				Henkilo henkilo = new Henkilo(tunnus, etunimi, sukunimi);
				henkiloDao.talleta(henkilo);
				
				break;
				
			case 4:
				System.out.println("-------------------");
				System.out.println("LISTATAAN KAIKKI TUNTIKIRJAUKSET");
				System.out.println("-------------------\n");
				
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
				int kirjaajaHlo_tunnus;
				String selite;
				int tunnit;
								
				Date pvm = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String hlo_pvm = dateFormat.format(pvm);
				System.out.println(hlo_pvm);
				
				System.out.println("Anna kirjaajan hlo_tunnus");
				input.nextLine();
				kirjaajaHlo_tunnus = input.nextInt();
				
				System.out.println("Anna kirjaukseen liittyvä selite");
				input.nextLine();
				selite = input.nextLine();
								
				System.out.println("Montako tuntia tuli tehtyä?");
				tunnit = input.nextInt();
								
				Tuntikirjaus uusiTuntikirjaus = new Tuntikirjaus(0, kirjaajaHlo_tunnus, selite, tunnit, hlo_pvm);
				tuntikirjausDao.talleta(uusiTuntikirjaus);
								
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