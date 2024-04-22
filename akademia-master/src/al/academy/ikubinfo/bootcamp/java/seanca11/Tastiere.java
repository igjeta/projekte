package al.academy.ikubinfo.bootcamp.java.seanca11;

public class Tastiere {

	private String kompaniaProdhuese;
	private String modeli;

	public Tastiere(String kompaniaProdhuese, String modeli) {
		super();
		this.kompaniaProdhuese = kompaniaProdhuese;
		this.modeli = modeli;
	}

	public Tastiere() {

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

	public void ndizCapsLock() {
		System.out.println("CapsLock on");
	}

	public void ndizNumLock() {
		System.out.println("NumLock on");
	}
}
