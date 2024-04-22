package klinike.dentare;

import java.util.ArrayList;
import java.util.List;

public class Rast {

	private static int idPare = 1;
	private int idRast;
	private Pacient pacient;
	private Mjek mjek;
	private Dhembet dhemb;
	private List<Seance> seance;
	private boolean dhembIperfunduar;

	public Rast(Pacient pacient,Mjek mjek, Dhembet dhemb) {
		this.pacient = pacient;
		this.mjek=mjek;
		this.dhemb = dhemb;
		this.seance=new ArrayList<>();
		dhembIperfunduar = false;
		this.idRast=idPare++;
	}

	public boolean isDhembIperfunduar() {
		return dhembIperfunduar;
	}

	public void setDhembIperfunduar(boolean dhembIperfunduar) {
		this.dhembIperfunduar = dhembIperfunduar;
	}
	public void perfundoRast() {
		this.dhembIperfunduar=true;
	}


	public List<Seance> getSeance() {
		return seance;
	}


	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	public Dhembet getDhemb() {
		return dhemb;
	}

	public void setDhemb(Dhembet dhemb) {
		this.dhemb = dhemb;
	}


	public Mjek getMjek() {
		return mjek;
	}

	public void setMjek(Mjek mjek) {
		this.mjek = mjek;
	}

	public int getIdRast() {
		return idRast;
	}

	@Override
	public String toString() {
		return "Rast [idRast=" + idRast + ", pacient=" + pacient + ", mjek=" + mjek + ", dhemb=" + dhemb
				+ ", dhembIperfunduar=" + dhembIperfunduar + "]";
	}

		

	

}
