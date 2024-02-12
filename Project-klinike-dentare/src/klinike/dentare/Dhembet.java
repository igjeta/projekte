package klinike.dentare;

public enum Dhembet {
	DHEMBI_1, DHEMBI_2, DHEMBI_3, DHEMBI_4, DHEMBI_5, DHEMBI_6, DHEMBI_7, DHEMBI_8, DHEMBI_9, DHEMBI_10, DHEMBI_11,
	DHEMBI_12, DHEMBI_13, DHEMBI_14, DHEMBI_15, DHEMBI_16, DHEMBI_17, DHEMBI_18, DHEMBI_19, DHEMBI_20, DHEMBI_21,
	DHEMBI_22, DHEMBI_23, DHEMBI_24, DHEMBI_25, DHEMBI_26, DHEMBI_27, DHEMBI_28, DHEMBI_29, DHEMBI_30, DHEMBI_31,
	DHEMBI_32;
	
	 public int getNumerDhemb() {
	        return ordinal() + 1;
	    }
	 
	 public String getEmerDhembi() {
	        return "DHEMBI_" + (ordinal() + 1);
	    }
	 
}
