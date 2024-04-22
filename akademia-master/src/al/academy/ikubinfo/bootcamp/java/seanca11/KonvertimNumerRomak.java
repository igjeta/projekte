package al.academy.ikubinfo.bootcamp.java.seanca11;

import java.util.HashMap;

public class KonvertimNumerRomak {

	public static int konvertoRomakNeArab(String numriRomak) {
		HashMap<Character, Integer> vleratRomake = new HashMap<>();
		vleratRomake.put('I', 1);
		vleratRomake.put('V', 5);
		vleratRomake.put('X', 10);
		vleratRomake.put('L', 50);
		vleratRomake.put('C', 100);
		vleratRomake.put('D', 500);
		vleratRomake.put('M', 1000);

		int rezultati = 0;

		for (int i = 0; i < numriRomak.length(); i++) {
			char karakteriAktual = numriRomak.charAt(i);
			int vleraAktuale = vleratRomake.get(karakteriAktual);

			if (i < numriRomak.length() - 1) {
				char karakteriPasardhes = numriRomak.charAt(i + 1);
				int vleraPasardhes = vleratRomake.get(karakteriPasardhes);

				if (vleraAktuale < vleraPasardhes) {
					rezultati -= vleraAktuale;
				} else {
					rezultati += vleraAktuale;
				}
			} else {
				rezultati += vleraAktuale;
			}
		}

		return rezultati;
	}

	public static void main(String[] args) {
		String numerRomak = "MCMXCV";
		int numerArab = konvertoRomakNeArab(numerRomak);
		System.out.println(numerRomak + " = " + numerArab);
	}

}
