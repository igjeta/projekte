package al.academy.ikubinfo.bootcamp.java.seanca11;

public class MainHyrjeOOP {
	public static void main(String[] args) {

		Laptop laptop = new Laptop("Dell", "XPS 15");
		Tastiere tastiere = new Tastiere("Dell", "057N9K");
		Kufje kufje = new Kufje("Plantronics", "C3200");
		Maus maus = new Maus("Dell", "056N8K");
		DockingStation dock = new DockingStation("Dell", "422X3G");
		
		Laptop laptop1 = new Laptop();
		Tastiere tastiere1 = new Tastiere();
		Kufje kufje1 = new Kufje();
		Maus maus1 = new Maus();
		DockingStation dock1 = new DockingStation();
		
		laptop1.setKompaniaProdhuese("laptop1");
		laptop1.setModeli("latop1");
		
		tastiere1.setKompaniaProdhuese("tastiere1");
		tastiere1.setModeli("tastiere1");
		
		kufje1.setKompaniaProdhuese("kufje1");
		kufje1.setModeli("kufje1");
		
		maus1.setKompaniaProdhuese("maus1");
		maus1.setModeli("maus1");
		
		dock1.setKompaniaProdhuese("dock1");
		dock1.setModeli("dock1");
		
		System.out.println(laptop1.getKompaniaProdhuese()+" "+laptop1.getModeli());
		System.out.println(tastiere1.getKompaniaProdhuese()+" "+tastiere1.getModeli());
		System.out.println(kufje1.getKompaniaProdhuese()+" "+kufje1.getModeli());
		System.out.println(maus1.getKompaniaProdhuese()+" "+maus1.getModeli());
		System.out.println(dock1.getKompaniaProdhuese()+" "+dock1.getModeli());
		
		
		laptop1.ndizLaptop();
		laptop1.fikLaptop();
		
		tastiere1.ndizCapsLock();
		tastiere1.ndizNumLock();
		
		kufje1.ngriVolumin();
		kufje1.ulVolumin();
		
		maus1.klikoMeTeDjathten();
		maus1.klikoMeTeMajten();
		
		dock1.ndizDockingStation();
		dock.fikDockingStation();
		
		
	}
}
