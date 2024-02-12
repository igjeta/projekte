package al.academy.ikubinfo.bootcamp.java.seanca11;

public class Maus {
	private String kompaniaProdhuese;
	private String modeli;

	public Maus(String kompaniaProdhuese, String modeli) {
		super();
		this.kompaniaProdhuese = kompaniaProdhuese;
		this.modeli = modeli;
	}

	public Maus() {

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

	public void klikoMeTeMajten() {
		System.out.println("klik butoni majte");
	}

	public void klikoMeTeDjathten() {
		System.out.println("klik butoni djathte");
	}
}
