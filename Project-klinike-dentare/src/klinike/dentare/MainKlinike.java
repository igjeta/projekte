package klinike.dentare;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainKlinike {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Klinike klinika = new Klinike();

		int zgjidh;
		boolean vazhdo = true;
		while (vazhdo) {
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			printoListeZgjedhjesh();
			System.out
					.println("Shkruani numrin per metoden qe doni te zgjidhni ose nje numer tjeter per te perfunduar:");
			zgjidh = input.nextInt();
			input.nextLine();
			switch (zgjidh) {
			case 1:
				shtoPacient(klinika);
				klinika.shfaqTeGjithePacientet();
				break;
			case 2:
				klinika.shfaqTeGjithePacientet();
				break;
			case 3:
				shtoMjek(klinika);
				klinika.shfaqTeGjitheMjeket();
				break;
			case 4:
				klinika.shfaqTeGjitheMjeket();
				break;
			case 5:
				klinika.shfaqTeGjitheMjeket();
				System.out.println("Shkruaj id e mjekut qe doni te fshini.");
				int idMjek = input.nextInt();
				klinika.fshijMjek(idMjek);
				input.nextLine();
				break;
			case 6:
				klinika.shfaqTeGjithePacientet();
				System.out.println("Shkruaj id e pacientit qe doni te fshini.");
				int idPacient = input.nextInt();
				klinika.fshijPacient(idPacient);
				input.nextLine();
				break;
			case 7:
				LocalDateTime tempOrar = shkruajOrar();
				Mjek tempMjek = klinika.gjejMjekById();
				Pacient pacient = klinika.gjejPacientById();
				klinika.rezervoOrar(tempMjek, pacient, tempOrar);
				klinika.shfaqRezervimet();
				break;
			case 8:
				klinika.shfaqRezervimet();
				break;
			case 9:
				Mjek rastMjek = klinika.gjejMjekById();
				Pacient rastPacient = klinika.gjejPacientById();
				Dhembet rastDhemb = gjejDhembId();
				klinika.krijoRast(rastPacient, rastMjek, rastDhemb);
				klinika.shfaqRastet();
				break;
			case 10:
				klinika.shfaqRastet();
				break;
			case 11:
				klinika.anulloRezervim();
				break;
			case 12:
				klinika.printoPacientMeRezervime();
				break;
			case 13:
				klinika.printoDhembiMeMShumeRaste();
				break;
			case 14:
				klinika.shtoSeance();
				break;
			case 15:
				klinika.mbyllSeance();
				break;
			case 16:
				int muajTemp = merrMuaj();
				int vitTemp = merrVit();
				klinika.anullimetPerMuaj(muajTemp, vitTemp);
				break;
			case 17:
				int muajTemp1 = merrMuaj();
				int vitTemp1 = merrVit();
				klinika.rezervimetPerMuaj(muajTemp1, vitTemp1);
				break;
			case 18:
				klinika.doktorMeVizita();
				break;
			default:
				System.out.println("Programi i mbyll");
				vazhdo = false;

			}

		}
	}

	// ----------------metoda ndihmse----------------

	public static void printoListeZgjedhjesh() {
		System.out.println("Menu kryesore: ");
		System.out.println("1-Shto pacient");
		System.out.println("2-Afisho pacient");
		System.out.println("3-Shto mjek");
		System.out.println("4-Afisho mjek");
		System.out.println("5-Fshi mjek");
		System.out.println("6-Fshi pacient");
		System.out.println("7-Rezervo orar");
		System.out.println("8-Afisho rezervimet");
		System.out.println("9-Krijo rast");
		System.out.println("10-Afisho rastet");
		System.out.println("11-Anullo rezervim");
		System.out.println("12-Afisho pacient me me shume rezervime");
		System.out.println("13-Afisho dhembin me me shume raste");
		System.out.println("14-Shto seance");
		System.out.println("15-Mbyll seance");
		System.out.println("16-Anullime per muaj dhe vit");
		System.out.println("17-Rezervime per muaj dhe vit");
		System.out.println("18-Doktori me me shume rezervime");
	}

	public static int merrMuaj() {
		Scanner scanner = new Scanner(System.in);
		int muaji;

		while (true) {
			try {
				System.out.println("Shkruaj muajin (1-12): ");
				muaji = scanner.nextInt();

				if (muaji >= 1 && muaji <= 12) {
					break;
				} else {
					System.out.println("Muaji duhet te jete nga 1 deri 12. Provo perseri.");
				}
			} catch (Exception e) {
				System.out.println("Inputi duhet te jete int.");
				scanner.nextLine();
			}
		}

		return muaji;
	}

	public static int merrVit() {
		Scanner scanner = new Scanner(System.in);
		int viti;

		while (true) {
			try {
				System.out.println("Shkruaj vitin: ");
				viti = scanner.nextInt();

				if (viti >= 0) {
					break;
				} else {
					System.out.println("Viti duhet te jete numer pozitiv. Provo perseri.");
				}
			} catch (Exception e) {
				System.out.println("Inputi duhet te jete int.");
				scanner.nextLine();
			}
		}

		return viti;
	}

	public static void shtoPacient(Klinike klinika) {
		String emri = shkruajEmer();
		String mbiemri = shkruajMbiemer();
		String nid = shkruajNid();
		LocalDate dataLindjes = shkruajDateLindje();

		Pacient pacient = new Pacient(emri, mbiemri, nid, dataLindjes);
		klinika.shtoPacient(pacient);

		System.out.println("Pacienti u shtua me sukses!");
	}

	public static void shtoMjek(Klinike klinika) {
		String emri = shkruajEmer();
		String mbiemri = shkruajMbiemer();
		String nid = shkruajNid();
		LocalDate dataLindjes = shkruajDateLindje();

		Mjek mjek = new Mjek(emri, mbiemri, nid, dataLindjes);
		klinika.shtoMjek(mjek);

		System.out.println("Mjeku u shtua me sukses!");
	}

	// shkruaj emer
	public static String shkruajEmer() {
		Scanner input = new Scanner(System.in);
		String emri;

		do {
			System.out.println("Shkruaj emer (minimum 3 karaktere): ");
			emri = input.next();

			if (emri.length() < 3) {
				System.out.println("Emri duhet te kete te pakten 3 karaktere. Ju lutemi shkruani perseri.");
			}
		} while (emri.length() < 3);

		return emri;
	}

	// Shkruaj mbiemer
	public static String shkruajMbiemer() {
		Scanner input = new Scanner(System.in);
		String mbiemri;

		do {
			System.out.println("Shkruaj mbiemer (minimum 3 karaktere): ");
			mbiemri = input.next();

			if (mbiemri.length() < 3) {
				System.out.println("Mbiemri duhet te kete te pakten 3 karaktere. Ju lutemi shkruani perseri.");
			}
		} while (mbiemri.length() < 3);

		return mbiemri;
	}

	// shkruaj nid
	public static String shkruajNid() {
		Scanner input = new Scanner(System.in);
		String nid;

		do {
			System.out.println("Shkruaj nid (10 karaktere): ");
			nid = input.next();

			if (nid.length() != 10) {
				System.out.println("Nid duhet te kete 10 karaktere. Ju lutemi shkruani perseri.");
			}
		} while (nid.length() != 10);

		return nid;
	}

	// shkruaj datelindje
	public static LocalDate shkruajDateLindje() {
		Scanner input = new Scanner(System.in);
		LocalDate dataAktuale = LocalDate.now();
		LocalDate dateLindje = null;

		do {
			System.out.println("Shkruaj datelindjen (YYYY-MM-DD): ");
			String dataInput = input.nextLine();

			try {
				dateLindje = LocalDate.parse(dataInput);

				if (dateLindje.isAfter(dataAktuale)) {
					System.out.println("Datelindja nuk mund te jete me e vogel se data aktuale.");
					dateLindje = null;
				}
			} catch (DateTimeParseException e) {
				System.out.println("Format i pasakte. Ju lutemi shkruani daten ne formatin e duhur.");
			}

		} while (dateLindje == null);

		return dateLindje;
	}

	// orari rezervim
	public static LocalDateTime shkruajOrar() {
		Scanner input = new Scanner(System.in);
		LocalDateTime orariAktual = LocalDateTime.now();
		LocalDateTime orari = null;

		do {
			System.out.println("Shkruaj orarin (YYYY-MM-DD HH:mm): ");
			String orariInput = input.nextLine();

			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				orari = LocalDateTime.parse(orariInput, formatter);

				LocalTime kohaZgjedhur = orari.toLocalTime();
				if (kohaZgjedhur.isBefore(LocalTime.of(8, 0)) || kohaZgjedhur.isAfter(LocalTime.of(17, 0))) {
					System.out.println("Orari nuk mund te jete para se ora 08:00 ose pas ores 17:00.");
					orari = null;
					continue;
				}

				if (!orari.toLocalDate().isAfter(orariAktual.toLocalDate())
						|| orari.toLocalDate().isEqual(orariAktual.toLocalDate())
								&& kohaZgjedhur.isBefore(orariAktual.toLocalTime())) {
					System.out.println("Data duhet te jete mbas dites aktuale");
					orari = null;
				}

			} catch (DateTimeParseException e) {
				System.out.println("Format i pasakte. Ju lutemi shkruani orarin në formatin e duhur.");
			}

		} while (orari == null);

		return orari;
	}

	public static Dhembet gjejDhembId() {
		Scanner input = new Scanner(System.in);
		Dhembet dhemb = null;

		do {
			System.out.println("Shkruaj id e dhembit (1-32): ");
			int idDhemb = input.nextInt();

			if (idDhemb >= 1 && idDhemb <= Dhembet.values().length) {
				dhemb = Dhembet.values()[idDhemb - 1];
			} else {
				System.out.println("ID e dhembit duhet te jete nga 1 ne 32. Provo perseri.");
			}

		} while (dhemb == null);

		return dhemb;
	}

}
