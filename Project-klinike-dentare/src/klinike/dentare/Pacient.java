package klinike.dentare;

import java.time.LocalDate;

public class Pacient extends Person {

	private static int idPare = 1;
	private int idPacient;

	public Pacient(String emri, String mbiemri, String nid, LocalDate dataLindjes) {
		super(emri, mbiemri, nid, dataLindjes);
		this.idPacient = idPare++;
	}

	public int getIdPacient() {
		return idPacient;
	}

	@Override
	public String toString() {
		return "Pacient [idPacient=" + idPacient + ", emri=" + getEmri() + ", mbiemeri=" + getMbiemri()
				+ ", nid=" + getNid() + ", DataLindjes=" + getDataLindjes() + "]";
	}

}
