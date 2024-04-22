package klinike.dentare;

import java.time.LocalDateTime;

public class Rezervim {
	private static int idPare = 1;
	private int idRezervim;
	private Mjek mjek;
	private Pacient pacient;
	private LocalDateTime orari;
	private boolean ePerfunduar;
	private boolean anulluar;

	public Rezervim(Mjek mjek, Pacient pacient, LocalDateTime orari) {
		this.mjek = mjek;
		this.pacient = pacient;
		this.orari = orari;
		this.ePerfunduar = false;
		this.anulluar=false;
		this.idRezervim=idPare++;
	}

	public boolean isAnulluar() {
		return anulluar;
	}

	public void anullo() {
		this.anulluar = true;
	}

	public Mjek getMjek() {
		return mjek;
	}

	public void setMjek(Mjek mjek) {
		this.mjek = mjek;
	}

	public LocalDateTime getOrari() {
		return orari;
	}

	public void setOrari(LocalDateTime orari) {
		this.orari = orari;
	}

	public boolean isEPerfunduar() {
		return ePerfunduar;
	}

	public void setEPerfunduar(boolean ePerfunduar) {
		this.ePerfunduar = ePerfunduar;
	}

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}
	

	public int getIdRast() {
		return idRezervim;
	}

	public void setIdRast(int idRast) {
		this.idRezervim = idRast;
	}

	public boolean isePerfunduar() {
		return ePerfunduar;
	}

	public void setePerfunduar(boolean ePerfunduar) {
		this.ePerfunduar = ePerfunduar;
	}

	@Override
	public String toString() {
		return "Rezervim [idRast=" + idRezervim + ", mjek=" + mjek + ", pacient=" + pacient + ", orari=" + orari
				+ ", ePerfunduar=" + ePerfunduar + "]";
	}

}
