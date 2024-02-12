package klinike.dentare;

import java.time.LocalDate;

public class Mjek extends Person {
	
	private static int idPare = 1;
	private int idMjeku;

	public Mjek(String emri, String mbiemri, String nid, LocalDate dataLindjes) {
		super(emri, mbiemri, nid, dataLindjes);
		this.idMjeku = idPare++;
	}

	public int getIdMjeku() {
		return idMjeku;
	}

	@Override
	public String toString() {
		return "Mjek [idMjeku=" + idMjeku + ", Emri=" + getEmri() + ", Mbiemri=" + getMbiemri()
				+ ", Nid=" + getNid() + ", DataLindjes=" + getDataLindjes() + "]";
	}
	
	
}
