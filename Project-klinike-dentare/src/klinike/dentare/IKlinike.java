package klinike.dentare;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IKlinike {

	void shtoMjek(Mjek mjek);

	void fshijMjek(int idMjeku);

	void shfaqTeGjitheMjeket();

	void shtoPacient(Pacient pacient);

	void fshijPacient(int idPacient);

	void shfaqTeGjithePacientet();

	void rezervoOrar(Mjek mjek, Pacient pacient, LocalDateTime orari);

	void krijoRast(Pacient pacient, Mjek mjek, Dhembet dhemb);

	void anulloRezervim();

	 List<Pacient> pacientMeRezervime();

	List<Dhembet>dhembiMeMeShumeRaste();

	void doktorMeVizita();

	void rezervimetPerMuaj(int muaji, int viti);

	void anullimetPerMuaj(int muaji, int viti);
}
