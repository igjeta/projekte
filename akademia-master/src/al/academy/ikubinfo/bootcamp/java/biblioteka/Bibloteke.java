package al.academy.ikubinfo.bootcamp.java.biblioteka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bibloteke implements IBibloteka {

	private List<Liber> libra;
	private List<Lexues> lexuesi;
	private List<Autor> autoret;
	private Scanner input;

	public Bibloteke() {
		libra = new ArrayList<>();
		lexuesi = new ArrayList<>();
		autoret = new ArrayList<>();

		Autor autor = new Autor("Ismail", "Kadare", LocalDate.of(1955, 01, 01));
		Autor autor2 = new Autor("Viktor", "Hygo", LocalDate.of(1966, 02, 02));
		autoret.add(autor);
		autoret.add(autor2);

		Lexues lexues = new Lexues("ilirjan", "Gjeta", "gjetailirjan95@gmail.com", "12345", LocalDate.of(2023, 10, 10));
		Lexues lexues1 = new Lexues("John", "Doe", "johndoe@gmail.com", "12345", LocalDate.of(2023, 10, 10));

		lexuesi.add(lexues);
		lexuesi.add(lexues1);

		Liber liber = new Liber("Dimri i fundit", "0000000000000", 1967, Arrays.asList(autor2), Zhaner.ROMAN);
		Liber liber1 = new Liber("Dimri i fundit 1", "1111111111111", 1967, Arrays.asList(autor), Zhaner.ROMAN);
		Liber liber2 = new Liber("Dimri i fundit 2", "2222222222222", 1967, Arrays.asList(autor2), Zhaner.BIOGRAFI);
		Liber liber3 = new Liber("Dimri i fundit 3", "3333333333333", 1967, Arrays.asList(autor2), Zhaner.FILOZOFI);

		libra.add(liber);
		libra.add(liber1);
		libra.add(liber2);
		libra.add(liber3);

		for (Lexues lex : lexuesi) {
			inicializoMarrHuaStatusPerLexuesin(lex);
		}
	}

	// ----------Metodat------
	// shto liber
	@Override
	public Liber shtoLiber(String titulli, String isbn, int vitiProdhimi, Zhaner zhaner, List<Autor> autoret) {
		return new Liber(titulli, isbn, vitiProdhimi, autoret, zhaner);
	}

	// fshij liber me ISBN
	@Override
	public void fshiLiberMeIsbn(String isbn) {
		for (Liber liber : libra) {
			if (liber.getIsbn().equals(isbn)) {
				libra.remove(liber);
				System.out.println("Libri me isbn " + isbn + " u fshi me sukses!");
				return;
			}
		}

		System.out.println("Nuk u gjet liber me ISBN " + isbn + "!");
	}

	// kerko liber me titull ose emer autori ose ISBN
	@Override
	public Liber kerkoLibrin(String input) {
		for (Liber liber : libra) {
			if (liber.getTitull().equalsIgnoreCase(input) || liber.getIsbn().equals(input) || kaAutor(liber, input)) {

				return liber;
			}
		}
		return null;
	}

	private boolean kaAutor(Liber liber, String emriAutorit) {
		for (Autor autor : liber.getAutoret()) {
			String emriMbiemer = autor.getEmer() + " " + autor.getMbiemer();
			if (emriMbiemer.equalsIgnoreCase(emriAutorit)) {
				return true;
			}
		}
		return false;
	}

	// shfaq te gjithe librat
	@Override
	public void shfaqTeGjitheLibrat() {
		for (Liber liber : libra) {
			System.out.println(liber.toString());
		}
	}

	// merr liber hua
	@Override
	public void merrLiberHua(Lexues lexues, Liber liber) {
		Map<Liber, Boolean> marrHuaStatus = lexues.getMarrHuaStatus();
		Map<Liber, Boolean> lexuarStatus = lexues.getLexuarStatus();

		if (!lexues.mundTeMarreLibrin()) {
			System.out.println("Lexuesi nuk mund ta marr librin pasi ka kaluar limitin 3 here.");
			return;
		}
		if (marrHuaStatus.get(liber) != null && marrHuaStatus.get(liber)) {
			System.out.println("Libri eshte i huazuar per momentin.");
			return;
		}

		marrHuaStatus.put(liber, true);
		lexuarStatus.put(liber, false);
	}

	// kthe liber
	@Override
	public void ktheLiber(Lexues lexues, Liber liber) {
		Map<Liber, Boolean> marrHuaStatus = lexues.getMarrHuaStatus();

		if (marrHuaStatus.get(liber) != null && marrHuaStatus.get(liber)) {
			marrHuaStatus.put(liber, false);
			System.out.println("Libri u kthye me sukses!");
		} else {
			System.out.println("Libri nuk eshte huazuar nga ky lexues.");
		}
	}

	// shto lexues
	@Override
	public void shtoLexues(String emer, String mbiemer, String email, String password, LocalDate dataRegjistrimit) {
		Lexues lexues = new Lexues(emer, mbiemer, email, password, dataRegjistrimit);
		inicializoMarrHuaStatusPerLexuesin(lexues);
		lexuesi.add(lexues);
		System.out.println("Lexuesi u regjistrua!");
	}

	// fshi lexues
	@Override
	public void fshiLexues(Lexues lexues) {
		if (lexuesi.contains(lexues)) {
			lexuesi.remove(lexues);
			System.out.println("Lexuesi u fshi!");
		} else {
			System.out.println("Lexuesi nuk u gjet!");
		}
	}

	// personi qe ka lexuar me shume libra
	@Override
	public Lexues personiMeShumeLibra() {
		Lexues personiMeShumeLibra = null;
		int maxLibraLexuar = 0;

		for (Lexues lexues : lexuesi) {
			int numriLibraveLexuar = lexues.getMarrHuaStatus().size();
			if (numriLibraveLexuar > maxLibraLexuar) {
				maxLibraLexuar = numriLibraveLexuar;
				personiMeShumeLibra = lexues;
			}
		}

		return personiMeShumeLibra;
	}

	// libri me i lexuar
	@Override
	public Liber libriMeILexuar() {
		Map<Liber, Integer> numriHuazimeve = new HashMap<>();

		for (Lexues lexues : lexuesi) {
			Map<Liber, Boolean> marrHuaStatus = lexues.getMarrHuaStatus();

			for (Liber liber : marrHuaStatus.keySet()) {
				if (marrHuaStatus.get(liber) != null && marrHuaStatus.get(liber)) {
					numriHuazimeve.put(liber, numriHuazimeve.getOrDefault(liber, 0) + 1);
				}
			}
		}

		Liber libriMeILexuar = null;
		int maxHuazimet = 0;

		for (Map.Entry<Liber, Integer> entry : numriHuazimeve.entrySet()) {
			if (entry.getValue() > maxHuazimet) {
				maxHuazimet = entry.getValue();
				libriMeILexuar = entry.getKey();
			}
		}

		return libriMeILexuar;
	}

	// mesatarja e librave te lexuar per person
	@Override
	public double mesatarjaLibravePerPerson() {
		int totalLibratELexuar = 0;
		for (Lexues lexues : lexuesi) {
			Map<Liber, Boolean> marrHuaStatus = lexues.getMarrHuaStatus();

			for (Boolean huazuar : marrHuaStatus.values()) {
				if (huazuar) {
					totalLibratELexuar++;
				}
			}
		}

		double mesatarja = (double) totalLibratELexuar / lexuesi.size();
		return mesatarja;
	}

	// lista e librave qe ka lexuar nje lexues
	@Override
	public List<Liber> listaLibraveTeLexuaraPerLexuesin(Lexues lexues) {
		return lexues.getLibratLexuar();
	}

	// lista e lexuesve te librit me nje titull te caktuar
	@Override
	public List<Lexues> lexuesitELiberitMeTitull(String titulli) {
		List<Lexues> lexuesitELiberit = new ArrayList<>();

		for (Liber liber : libra) {
			if (liber.getTitull().equalsIgnoreCase(titulli)) {
				for (Lexues lexues : lexuesi) {
					Boolean status = lexues.getMarrHuaStatus().get(liber);
					if (status != null && status) {
						lexuesitELiberit.add(lexues);
					}
				}
			}
		}

		return lexuesitELiberit;
	}

	// zhaneri me i lexuar
	@Override
	public Zhaner zhaneriMeILexuar() {
		Map<Zhaner, Integer> counterZhaner = new HashMap<>();

		for (Liber liber : libra) {
			for (Lexues lexues : lexuesi) {
				Boolean status = lexues.getMarrHuaStatus().get(liber);
				if (status != null && status) {
					counterZhaner.put(liber.getZhaneriLibrit(),
							counterZhaner.getOrDefault(liber.getZhaneriLibrit(), 0) + 1);
				}
			}
		}

		Zhaner zhaneriMax = null;
		int maxCount = 0;
		for (Map.Entry<Zhaner, Integer> entry : counterZhaner.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				zhaneriMax = entry.getKey();
			}
		}

		return zhaneriMax;
	}

	// autori qe ka shkruar me shume libra
	@Override
	public Autor autoriMeShumeLibra() {
		Map<Autor, Integer> counterAutor = new HashMap<>();

		for (Liber liber : libra) {
			for (Autor autor : liber.getAutoret()) {
				counterAutor.put(autor, counterAutor.getOrDefault(autor, 0) + 1);
			}
		}

		Autor autorMax = null;
		int maxCount = 0;
		for (Map.Entry<Autor, Integer> entry : counterAutor.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				autorMax = entry.getKey();
			}
		}

		return autorMax;
	}

	// autori me i lexuar
	@Override
	public Autor autoriMeILexuar() {
		Map<Autor, Integer> counterAutor = new HashMap<>();

		for (Liber liber : libra) {
			for (Autor autor : liber.getAutoret()) {
				counterAutor.put(autor, counterAutor.getOrDefault(autor, 0) + 1);
			}
		}
		Autor autorMax = null;
		int maxCount = 0;
		for (Map.Entry<Autor, Integer> entry : counterAutor.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				autorMax = entry.getKey();
			}
		}

		return autorMax;
	}

	// ----------Metodat------fund

	public void inicializoMarrHuaStatusPerLexuesin(Lexues lexues) {
		Map<Liber, Boolean> marrHuaStatus = new HashMap<>();

		for (Liber liber : libra) {
			marrHuaStatus.put(liber, false);
		}

		lexues.setMarrHuaStatus(marrHuaStatus);
	}

	public List<Liber> getLibra() {
		return libra;
	}

	public void setLibra(List<Liber> libra) {
		this.libra = libra;
	}

	public List<Lexues> getLexuesi() {
		return lexuesi;
	}

	public void setLexuesi(List<Lexues> lexuesi) {
		this.lexuesi = lexuesi;
	}

	public List<Autor> getAutoret() {
		return autoret;
	}

	public void setAutoret(List<Autor> autoret) {
		this.autoret = autoret;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
}