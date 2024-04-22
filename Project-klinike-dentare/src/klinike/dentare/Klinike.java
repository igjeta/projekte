package klinike.dentare;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Klinike implements IKlinike {

	private List<Mjek> listaMjekve;
	private List<Pacient> listaPacienteve;
	private List<Rast> listaRasteve;
	private List<Rezervim> listaRezervimeve;

	Klinike() {
		listaMjekve = new ArrayList<>();
		listaPacienteve = new ArrayList<>();
		listaRasteve = new ArrayList<>();
		listaRezervimeve = new ArrayList<>();

		Mjek mjek1 = new Mjek("Test", "Test", "1234567890", LocalDate.of(1960, 01, 01));
		Pacient pacient1 = new Pacient("Test1", "Test1", "0234567891", LocalDate.of(1990, 02, 02));
		listaMjekve.add(mjek1);
		listaPacienteve.add(pacient1);

	}

	// ----------fillim metoda-----------

	@Override // done
	public void shtoMjek(Mjek mjek) {
		listaMjekve.add(mjek);
	}

	@Override // done
	public void fshijMjek(int idMjeku) {
		Mjek temp = null;
		boolean uGjet = false;
		for (Mjek mjek : listaMjekve) {
			if (mjek.getIdMjeku() == idMjeku) {
				temp = mjek;
				uGjet = true;
			}
		}
		if (uGjet) {
			listaMjekve.remove(temp);
			System.out.println("Mjeku u fshi me sukses.");
		} else {
			System.out.println("Mjeku nuk u gjet. Fshirja deshtoi.");
		}
	}

	@Override // done
	public void fshijPacient(int idPacient) {
		Pacient temp = null;
		boolean uGjet = false;
		for (Pacient pacient : listaPacienteve) {
			if (pacient.getIdPacient() == idPacient) {
				temp = pacient;
				uGjet = true;
			}
		}
		if (uGjet) {
			listaPacienteve.remove(temp);
			System.out.println("Pacienti u fshi me sukses.");
		} else {
			System.out.println("Pacienti nuk u gjet. Fshirja deshtoi.");
		}
	}

	@Override // done
	public void shfaqTeGjitheMjeket() {
		for (Mjek mjek : listaMjekve) {
			System.out.println(mjek);
		}
	}

	@Override // done
	public void shtoPacient(Pacient pacient) {
		listaPacienteve.add(pacient);
	}

	@Override // done
	public void shfaqTeGjithePacientet() {
		for (Pacient pacient : listaPacienteve) {
			System.out.println(pacient);
		}
	}

	@Override // done
	public void rezervoOrar(Mjek mjek, Pacient pacient, LocalDateTime orari) {
		LocalDateTime oraAktuale = LocalDateTime.now();

		if (orari.isAfter(oraAktuale.plusDays(1))) {
			for (Rezervim rezervim : listaRezervimeve) {
				if (rezervim.getMjek().equals(mjek) && rezervim.getOrari().equals(orari)) {
					System.out.println("Orari eshte i rezervuar.");

				}
			}

			listaRezervimeve.add(new Rezervim(mjek, pacient, orari));
			System.out.println("Rezervimi u krye me sukses.");
		} else {
			System.out.println("Rezervimi duhet te behet te pakten nje dite mbas dites aktuale.");
		}
	}

	// printo rezervime done
	public void shfaqRezervimet() {
		for (Rezervim rezervim : listaRezervimeve) {
			System.out.println(rezervim);
		}
	}

	// done
	@Override
	public void krijoRast(Pacient pacient, Mjek mjek, Dhembet dhemb) {

		boolean kaRastAktiv = listaRasteve.stream()
				.anyMatch(rast -> rast.getPacient().equals(pacient) && !rast.isDhembIperfunduar());
		if (kaRastAktiv) {
			System.out.println(
					"Ky pacient ka 1 rast aktive per kte dhemb. Nuk mund te shtohet nje rast i ri deri sa te perfundoje rasti aktual.");

		} else {

			Rast rast = new Rast(pacient, mjek, dhemb);
			listaRasteve.add(rast);

			System.out.println("Rasti u krijua me sukses!");
		}
	}

	// printo raste done
	public void shfaqRastet() {
		for (Rast rast : listaRasteve) {
			System.out.println(rast);
		}
	}

	// anullo rezervim done
	@Override
	public void anulloRezervim() {
		shfaqRezervime();
		Scanner input = new Scanner(System.in);
		System.out.println("Shkruaj id e rezervimit qe doni te anulloni");
		int idRezervim = -1;
		boolean uGjet = false;
		while (true) {
			try {
				idRezervim = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Inputi duhet te jete i tipit int.");
			}
		}
		for (Rezervim rezervim : listaRezervimeve) {
			if (rezervim.getIdRast() == idRezervim) {
				rezervim.anullo();
				uGjet = true;
				System.out.println("Rezervimi u anullua me sukses.");
				break;
			}
		}

		if (!uGjet) {
			System.out.println("Rezervimi me id " + idRezervim + " nuk u gjet. Anullimi nuk u realizua");
		}
	}

	// printo rezervim
	public void shfaqRezervime() {
		for (Rezervim rezervim : listaRezervimeve) {
			System.out.println(rezervim);
		}
	}

	// done
	@Override
	public List<Pacient> pacientMeRezervime() {
		Map<Pacient, Integer> rezervimePerPacient = new HashMap<>();
		int maxRezervime = 0;

		for (Rezervim rezervim : listaRezervimeve) {
			Pacient pacient = rezervim.getPacient();

			if (rezervimePerPacient.containsKey(pacient)) {
				rezervimePerPacient.put(pacient, rezervimePerPacient.get(pacient) + 1);
			} else {
				rezervimePerPacient.put(pacient, 1);
			}

			int rezervime = rezervimePerPacient.get(pacient);

			if (rezervime > maxRezervime) {
				maxRezervime = rezervime;
			}
		}

		List<Pacient> pacientetMeMaxRezervime = new ArrayList<>();
		for (Map.Entry<Pacient, Integer> entry : rezervimePerPacient.entrySet()) {
			if (entry.getValue() == maxRezervime) {
				pacientetMeMaxRezervime.add(entry.getKey());
			}
		}

		return pacientetMeMaxRezervime;
	}

	// done
	public void printoPacientMeRezervime() {
		List<Pacient> pacientetMeMaxRezervime = pacientMeRezervime();
		for (Pacient pacient : pacientetMeMaxRezervime) {
			System.out.println(pacient);
		}
	}

	// done
	@Override
	public List<Dhembet> dhembiMeMeShumeRaste() {

		Map<Dhembet, Integer> rastePerDhembin = new HashMap<>();
		int maxRaste = 0;

		for (Rast rast : listaRasteve) {
			Dhembet dhembi = rast.getDhemb();

			if (rastePerDhembin.containsKey(dhembi)) {
				rastePerDhembin.put(dhembi, rastePerDhembin.get(dhembi) + 1);
			} else {
				rastePerDhembin.put(dhembi, 1);
			}

			int raste = rastePerDhembin.get(dhembi);

			if (raste > maxRaste) {
				maxRaste = raste;
			}
		}

		List<Dhembet> dhembetMeMShumeRaste = new ArrayList<>();
		for (Map.Entry<Dhembet, Integer> entry : rastePerDhembin.entrySet()) {
			if (entry.getValue() == maxRaste) {
				dhembetMeMShumeRaste.add(entry.getKey());
			}
		}

		return dhembetMeMShumeRaste;
	}

	// printo done
	public void printoDhembiMeMShumeRaste() {
		List<Dhembet> dhembet = dhembiMeMeShumeRaste();
		for (Dhembet dhembi : dhembet) {
			System.out.println(dhembi);
		}
	}

// done
	@Override
	public void doktorMeVizita() {
		System.out.println("Doktori me numrin me te madh te rezervimeve:");

		Mjek doktoriMeMeTeShumtaRezervime = null;
		int maxRezervime = 0;

		for (Mjek mjek : listaMjekve) {
			int numriRezervimeve = 0;

			for (Rezervim rezervim : listaRezervimeve) {
				if (rezervim.getMjek().equals(mjek) && !rezervim.isAnulluar()) {
					numriRezervimeve++;
				}
			}

			if (numriRezervimeve > maxRezervime) {
				maxRezervime = numriRezervimeve;
				doktoriMeMeTeShumtaRezervime = mjek;
			}
		}

		if (doktoriMeMeTeShumtaRezervime != null) {
			System.out.println("Doktori me emrin " + doktoriMeMeTeShumtaRezervime.getEmri() + " ka " + maxRezervime
					+ " rezervime.");
		} else {
			System.out.println("Nuk ka asnje rezervim per doktor.");
		}
	}

	@Override
	public void rezervimetPerMuaj(int muaji, int viti) {
		Month month = Month.of(muaji);
		int count = 0;

		for (Rezervim rezervim : listaRezervimeve) {
			if (!rezervim.isAnulluar() && rezervim.getOrari().getMonth() == month
					&& rezervim.getOrari().getYear() == viti) {
				count++;
			}
		}

		System.out.println("Numri i rezervimeve te per muajin " + muaji + " te vitit " + viti + " : " + count);
	}

	@Override
	public void anullimetPerMuaj(int muaji, int viti) {
		Month month = Month.of(muaji);
		int count = 0;

		System.out.println("Lista e rezervimeve te anulluara per muajin " + muaji + " te vitit " + viti + ":");

		for (Rezervim rezervim : listaRezervimeve) {
			if (rezervim.getOrari().getMonth() == month && rezervim.getOrari().getYear() == viti
					&& rezervim.isAnulluar()) {
				System.out.println(rezervim);
				count++;
			}
		}

		if (count == 0) {
			System.out.println("Nuk ka rezervime te anulluara per kete muaj.");
		}
	}

	// gjej pacient me id
	public Pacient gjejPacientById() {
		Scanner input = new Scanner(System.in);
		Pacient pacient = null;

		do {
			System.out.println("Shkruaj id e pacientit: ");
			int idPacient = input.nextInt();

			for (Pacient temp : listaPacienteve) {
				if (temp.getIdPacient() == idPacient) {
					pacient = temp;
					break;
				}
			}

			if (pacient == null) {
				System.out.println("Pacienti nuk u gjet. Provo perseri.");
			}

		} while (pacient == null);

		return pacient;
	}

	// gjej mjek me id
	public Mjek gjejMjekById() {
		Scanner input = new Scanner(System.in);
		Mjek mjeku = null;

		do {
			System.out.println("Shkruaj id e mjekut: ");
			int idMjeku = input.nextInt();

			for (Mjek mjek : listaMjekve) {
				if (mjek.getIdMjeku() == idMjeku) {
					mjeku = mjek;
					break;
				}
			}

			if (mjeku == null) {
				System.out.println("Mjeku nuk u gjet. Provo perseri.");
			}

		} while (mjeku == null);

		return mjeku;
	}

	// shto Seance done
	public void shtoSeance() {
		Rast rast = gjejRastMeId();

		if (rast != null && !rast.isDhembIperfunduar()) {
			Seance seance = new Seance();
			rast.getSeance().add(seance);
			System.out.println("Seanca u shtua");
		} else {
			System.out.println("Seanca nuk u shtua pasi nuk ka rast ose rasti eshte i perfunduar");
		}
	}

	// mbyll Seance done
	public void mbyllSeance() {
		Rast rast = gjejRastMeId();

		if (rast != null && !rast.isDhembIperfunduar()) {
			List<Seance> seanca = rast.getSeance();
			if (!seanca.isEmpty()) {
				Seance lastSeance = seanca.get(seanca.size() - 1);
				lastSeance.perfundoSeance();
				System.out.println("Seanca u mbyll");
			} else {
				System.out.println("Nuk ka seance ne rastin");
			}
		} else {
			System.out.println("Seanca nuk u mbyll pasi nuk ka rast ose rasti eshte i perfunduar");//
		}
	}

	// gjej Rast me id done
	private Rast gjejRastMeId() {
		Scanner input = new Scanner(System.in);
		shfaqRastet();
		System.out.println("Shkruaj id e Rastit");
		int idRast = -1;
		boolean uGjet = false;
		while (true) {
			try {
				idRast = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Inputi duhet te jete i tipit int.");
			}
		}
		for (Rast rast : listaRasteve) {
			if (rast.getIdRast() == idRast) {
				return rast;
			}
		}
		return null;
	}

	// --------------fund metoda------------

	public List<Mjek> getListaMjekve() {
		return listaMjekve;
	}

	public List<Pacient> getListaPacienteve() {
		return listaPacienteve;
	}

	public List<Rast> getListaRasteve() {
		return listaRasteve;
	}

}
