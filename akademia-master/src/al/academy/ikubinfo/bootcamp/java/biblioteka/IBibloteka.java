package al.academy.ikubinfo.bootcamp.java.biblioteka;

import java.time.LocalDate;
import java.util.List;

public interface IBibloteka {
	Liber shtoLiber(String titulli, String isbn, int vitiProdhimi, Zhaner zhaner, List<Autor> autoret);

	void fshiLiberMeIsbn(String isbn);

	Liber kerkoLibrin(String input);

	void shfaqTeGjitheLibrat();

	void merrLiberHua(Lexues lexues, Liber liber);

	void ktheLiber(Lexues lexues, Liber liber);

	void shtoLexues(String emer, String mbiemer, String email, String password, LocalDate dataRegjistrimit);

	void fshiLexues(Lexues lexues);

	Lexues personiMeShumeLibra();

	Liber libriMeILexuar();

	double mesatarjaLibravePerPerson();

	List<Liber> listaLibraveTeLexuaraPerLexuesin(Lexues lexues);

	List<Lexues> lexuesitELiberitMeTitull(String titulli);

	Zhaner zhaneriMeILexuar();

	Autor autoriMeShumeLibra();

	Autor autoriMeILexuar();
}
