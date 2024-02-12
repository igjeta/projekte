package al.academy.ikubinfo.bootcamp.java.seanca11;

public class Laptop {

	private String kompaniaProdhuese;
	private String modeli;

	public Laptop() {
	}

	public Laptop(String kompaniaProdhuese, String modeli) {
		super();
		this.kompaniaProdhuese = kompaniaProdhuese;
		this.modeli = modeli;
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

	public void ndizLaptop() {
		System.out.println("Ndiz Laptopin");
	}

	public void fikLaptop() {
		System.out.println("Fik laptopin");
	}

}
