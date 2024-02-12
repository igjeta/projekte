package al.academy.ikubinfo.bootcamp.java.seanca11;

public class DockingStation {

	private String kompaniaProdhuese;
	private String modeli;

	public DockingStation(String kompaniaProdhuese, String modeli) {
		super();
		this.kompaniaProdhuese = kompaniaProdhuese;
		this.modeli = modeli;
	}

	public DockingStation() {

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

	public void ndizDockingStation() {
		System.out.println("Ndiz DockingStation");
	}

	public void fikDockingStation() {
		System.out.println("Fik DockingStation");
	}

}
