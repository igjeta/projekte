package al.academy.ikubinfo.bootcamp.java.seanca14;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class ParkimStadiumAirAlbania {
	private static final int NUMRI_MAX_MJETESH = 100;

	private Map<MjetTransporti, Map<LocalDate, Integer>> parkingu;

	public ParkimStadiumAirAlbania() {
		parkingu = new HashMap<>();
	}

	public void shtoMjetTransportiNeParkim(MjetTransporti mjetTransporti) {
		if (numriMjeteveNeParkim() < NUMRI_MAX_MJETESH) {
			parkoMjetin(mjetTransporti, LocalDate.now());
			System.out.println("Mjeti u pakua.");
		} else {
			System.out.println("Parkimi eshte plote nuk mund te parkosh");
		}
	}

	public void rezervoParkimPerMjetTransportiDheDate(MjetTransporti mjetTransporti, LocalDate data) {
		if (numriMjeteveNeParkim() < NUMRI_MAX_MJETESH) {
			parkoMjetin(mjetTransporti, data);
			System.out.println("Rezervimi u krye per daten: " + data);
		} else {
			System.out.println("Rezervimi nuk mund te kryhet pasi parkimi eshte plot!");
		}
	}

	public int merrNumerParkimePerMuaj(int muaj) {
		int numerParkimeve = 0;
		LocalDate temp = LocalDate.now();

		for (Map.Entry<MjetTransporti, Map<LocalDate, Integer>> entry : parkingu.entrySet()) {
			for (Map.Entry<LocalDate, Integer> dataParkimit : entry.getValue().entrySet()) {
				if (dataParkimit.getKey().getMonthValue() == muaj
						&& dataParkimit.getKey().getYear() == temp.getYear()) {
					numerParkimeve += dataParkimit.getValue();
				}
			}
		}

		return numerParkimeve;
	}

	public void paguajParkim(MjetTransporti mjetTransporti) {
		double pagesa = 0.0;

		switch (mjetTransporti.getLloji()) {
		case MAKINE:
			pagesa = 200.0;
			break;
		case MOTORR:
			pagesa = 150.0;
			break;
		case BICIKLETE:
			pagesa = 100.0;
			break;
		}

		System.out.println("Pagesa prej " + pagesa + " u krye!");
	}

	public void llogaritFitimPerVit(int viti) {
		double fitimiTotal = 0.0;

		for (Map.Entry<MjetTransporti, Map<LocalDate, Integer>> entry : parkingu.entrySet()) {
			for (Map.Entry<LocalDate, Integer> dataParkimit : entry.getValue().entrySet()) {
				if (dataParkimit.getKey().getYear() == viti) {
					switch (entry.getKey().getLloji()) {
					case MAKINE:
						fitimiTotal += dataParkimit.getValue() * 200.0;
						break;
					case MOTORR:
						fitimiTotal += dataParkimit.getValue() * 150.0;
						break;
					case BICIKLETE:
						fitimiTotal += dataParkimit.getValue() * 100.0;
						break;
					}
				}
			}
		}

		System.out.println("Fitimi total eshte "+ fitimiTotal);
	}

	public void printoNrMjeteTransportiPerVit(int viti) {
	    Map<LlojiMjetit, Integer> numerMjetevePerLloj = new HashMap<>();

	    for (Map.Entry<MjetTransporti, Map<LocalDate, Integer>> entry : parkingu.entrySet()) {
	        for (Map.Entry<LocalDate, Integer> dataParkimit : entry.getValue().entrySet()) {
	            if (dataParkimit.getKey().getYear() == viti) {
	                LlojiMjetit llojiMjetit = entry.getKey().getLloji();
	                
	                if (numerMjetevePerLloj.containsKey(llojiMjetit)) {
	                    numerMjetevePerLloj.put(llojiMjetit, numerMjetevePerLloj.get(llojiMjetit) + dataParkimit.getValue());
	                } else {
	                    numerMjetevePerLloj.put(llojiMjetit, dataParkimit.getValue());
	                }
	            }
	        }
	    }

	    for (LlojiMjetit llojiMjetit : LlojiMjetit.values()) {
	        int numerMjeteve = numerMjetevePerLloj.getOrDefault(llojiMjetit, 0);
	        System.out.println(llojiMjetit + " - " + numerMjeteve + " mjete");
	    }
	}

	private int numriMjeteveNeParkim() {
		int numriMjeteve = 0;
		for (Map.Entry<MjetTransporti, Map<LocalDate, Integer>> entry : parkingu.entrySet()) {
			for (int numriParkuar : entry.getValue().values()) {
				numriMjeteve += numriParkuar;
			}
		}
		return numriMjeteve;
	}

	   private void parkoMjetin(MjetTransporti mjetTransporti, LocalDate dataMberritjes) {
	        if (!parkingu.containsKey(mjetTransporti)) {
	            parkingu.put(mjetTransporti, new HashMap<>());
	        }
	        Map<LocalDate, Integer> dataParkimit = parkingu.get(mjetTransporti);
	        dataParkimit.put(dataMberritjes, dataParkimit.getOrDefault(dataMberritjes, 0) + 1);
	    }

}
