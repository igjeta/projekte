package al.academy.ikubinfo.bootcamp.java.seanca11;

public class Kufje {

	private String kompaniaProdhuese;
	private String modeli;

	public Kufje(String kompaniaProdhuese, String modeli) {
		super();
		this.kompaniaProdhuese = kompaniaProdhuese;
		this.modeli = modeli;
	}

	public Kufje() {

	}

	public String getKompaniaProdhuese() {
		return kompaniaProdhuese;
	}

	public void setKompaniaProdhuese(String kompaniaProdhuese) {
		this.kompaniaProdhuese = kompaniaProdhuese;
	}

	public String getModeli() {
		return modeli;
	}

	public void setModeli(String modeli) {
		this.modeli = modeli;
	}

	public void ngriVolumin() {
		System.out.println("volumi u ngrit");
	}

	public void ulVolumin() {
		System.out.println("volumi u ul");
	}
}
