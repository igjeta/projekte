package al.academy.ikubinfo.bootcamp.java.pajisje.elektronike;

public class Laptop {

	static String sistemiOperimit;
	static int madhesiaRAM;
	static String tipiProcesorit;
	static boolean eshteNeShitje;

	static String emriPaisjes;
	static final int idPaisjes = 982165;

	public static void ktheGjendjeDheSisteminEOperimit() {
		System.out.println("Në gjendje: " + eshteNeShitje + "; Sistem operimi: " + sistemiOperimit);
	}

	 public static void inicializimiISistemitTeOperimit(String emriSistemit) {
	        sistemiOperimit = emriSistemit;
	    }
	 
	 public static void inicializimiIGjendjesLaptopit(boolean gjendjaLaptopit) {
		 eshteNeShitje = gjendjaLaptopit;
	    }
	 
	
	public static void main(String[] args) {

		inicializimiISistemitTeOperimit("Windows 11 pro x64 bit");
		inicializimiIGjendjesLaptopit(true);

		ktheGjendjeDheSisteminEOperimit();
		
		inicializimiISistemitTeOperimit("Linux");
		inicializimiIGjendjesLaptopit(false);

		ktheGjendjeDheSisteminEOperimit();

	}

}
