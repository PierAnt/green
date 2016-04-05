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
		Kayttaja kayttaja;
		Henkilo henkilo;
		
		boolean ajetaan = true;

		while (ajetaan) {
			int valinta;			
			
			System.out.println("\nVaihtoehdot:\n"
					+ "1. N�yt� kaikki henkil�t\n"
					+ "2. Valitse henkil� jona haluat tehd� kirjauksen (Ei viel� k�yt�ss�)\n"
					+ "3. Lis�� henkil� tuntiseurattavien piiriin\n"
					+ "4. N�yt� kaikki tuntikirjaukset\n"
					+ "5. Tee tuntikirjaus\n"
					+ "6. Poistu\n"
					
					+ "Valinta: ");
			
			valinta = input.nextInt();
			
			switch (valinta)
			{
			
			//Login
			case 0:
				henkilo  = henkiloDao.etsi(1);
				kayttaja = new Kayttaja(henkilo.getHlo_tunnus(), henkilo.getHlo_etunimi(), henkilo.getHlo_sukunimi());
				
				
				System.out.println(henkilo);
				System.out.println(kayttaja);
				
				
				break;
			
			//Listataan kaikki henkil�t
			case 1:
				System.out.println("-------------------");
				System.out.println("LISTATAAN KAIKKI HENKIL�T");
				System.out.println("-------------------\n");
				
				List<Henkilo> henkilot = henkiloDao.haeHenkilot();
				for (Henkilo h : henkilot) {
					System.out.println("Henkilon tunnus : " + h.getHlo_tunnus());
					System.out.println("Henkilon etunimi : " + h.getHlo_etunimi());
					System.out.println("Henkilon sukunimi : " + h.getHlo_sukunimi() + "\n");
				}
				break;
			
			//Valitse henkilo jona haluat tehd� kirjauksen
			case 2:
				break;
			
			//Lis�� henkil� tuntiseurattavien piiriin
			case 3:
				System.out.println("-------------------");
				System.out.println("Lis�� henkil� tuntiseurattavien piiriin");
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
				henkilo = new Henkilo(tunnus, etunimi, sukunimi);
				henkiloDao.talleta(henkilo);
				
				break;
			
			//N�yt� kaikki tuntikirjaukset
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
			
			//Tee tuntikirjaus
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
				
				System.out.println("Anna kirjaukseen liittyv� selite");
				input.nextLine();
				selite = input.nextLine();
								
				System.out.println("Montako tuntia tuli tehty�?");
				tunnit = input.nextInt();
								
				Tuntikirjaus uusiTuntikirjaus = new Tuntikirjaus(0, kirjaajaHlo_tunnus, selite, tunnit, hlo_pvm);
				tuntikirjausDao.talleta(uusiTuntikirjaus);
								
				break;			
			
			//Poistu   ---  (Lopulta t�h�n tulee Logout toiminto, joka kirjaa k�ytt�j�n ulos ja palaa login n�kym��n.)
			case 6:
				ajetaan = false;
				break;
			}
		}
					
		input.close();
		context.close();

	}

}