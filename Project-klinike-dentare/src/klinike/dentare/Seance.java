package klinike.dentare;

import java.time.LocalDateTime;

public class Seance {

	private static int idPare = 1;
	private int idSeance;
	private boolean eKryer;

	public Seance() {
		this.eKryer = false;
		this.idSeance=idPare++;
	}

	public void perfundoSeance() {
		this.eKryer = true;
	}

}
