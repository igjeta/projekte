package al.academy.ikubinfo.bootcamp.java.biblioteka;

import java.time.Year;
import java.util.List;

import al.academy.ikubinfo.bootcamp.java.biblioteka.exceptions.IsbnException;
import al.academy.ikubinfo.bootcamp.java.biblioteka.exceptions.TitulliException;
import al.academy.ikubinfo.bootcamp.java.biblioteka.exceptions.VitiProdhimitException;

public class Liber {

	private String titull;
	private String isbn;
	private int vitiProdhimit;
	private List<Autor> autoret;
	private Zhaner zhaneriLibrit;

	Liber(String titull, String isbn, int vitiProdhimit, List<Autor> autoret, Zhaner zhaneriLibrit) {
		super();
		this.titull = titull;
		this.isbn = isbn;
		this.vitiProdhimit = vitiProdhimit;
		this.autoret = autoret;
		this.zhaneriLibrit = zhaneriLibrit;
	}

	public String getTitull() {
		return titull;
	}

	public void setTitull(String titull) {
		if (titull.length() < 2) {
			throw new TitulliException("Titulli duhet te kete te pakten 2 karaktere.");
		}
		this.titull = titull;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn.length() != 13) {
			throw new IsbnException("ISBN duhet te kete 13 karaktere.");
		}
		this.isbn = isbn;
	}

	public int getVitiProdhimit() {
		return vitiProdhimit;
	}

	public void setVitiProdhimit(int vitiProdhimit) {
		int vitiAktual = Year.now().getValue();
		if (vitiProdhimit > vitiAktual) {
			throw new VitiProdhimitException("Viti i prodhimit nuk mund te jete me i madh se viti aktual.");
		}
		this.vitiProdhimit = vitiProdhimit;
	}

	public List<Autor> getAutoret() {
		return autoret;
	}

	public void setAutoret(List<Autor> autoret) {
		this.autoret = autoret;
	}

	public Zhaner getZhaneriLibrit() {
		return zhaneriLibrit;
	}

	public void setZhaneriLibrit(Zhaner zhaneriLibrit) {
		this.zhaneriLibrit = zhaneriLibrit;
	}

	@Override
	public String toString() {
		return "Liber [titull=" + titull + ", isbn=" + isbn + ", vitiProdhimit=" + vitiProdhimit + ", autoret="
				+ autoret + ", zhaneriLibrit=" + zhaneriLibrit + "]";
	}

}