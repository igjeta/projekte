package al.academy.ikubinfo.bootcamp.java.biblioteka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexues extends Person {

	private static final int LIMITI_HUA = 3;
	private String email;
	private String pasword;
	private LocalDate dataRegjistrimit;
	private List<Liber> librat;
	private Map<Liber, Boolean> marrHuaStatus;
	 private Map<Liber, Boolean> lexuarStatus;

	public Lexues(String emer, String mbiemer, String email, String pasword, LocalDate dataRegjistrimit) {
		super(emer, mbiemer);
		this.email = email;
		this.pasword = pasword;
		this.dataRegjistrimit = dataRegjistrimit;
		marrHuaStatus = new HashMap<>();
		lexuarStatus = new HashMap<>();
	}
	
	public List<Liber> getLibratLexuar() {
	    List<Liber> libratLexuar = new ArrayList<>();

	    for (Map.Entry<Liber, Boolean> entry : lexuarStatus.entrySet()) {
	        if (entry.getValue() != null && entry.getValue()) {
	            libratLexuar.add(entry.getKey());
	        }
	    }

	    return libratLexuar;
	}
	
	public boolean mundTeMarreLibrin() {
        return getMarrHuaStatus().size() < LIMITI_HUA;
    }
	
	public void statusLexuar(Liber liber) {
	    lexuarStatus.put(liber, true);
	}

	
	public Map<Liber, Boolean> getLexuarStatus() {
		return lexuarStatus;
	}

	public void setLexuarStatus(Map<Liber, Boolean> lexuarStatus) {
		this.lexuarStatus = lexuarStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public LocalDate getDataRegjistrimit() {
		return dataRegjistrimit;
	}

	public void setDataRegjistrimit() {
		dataRegjistrimit = LocalDate.now();
	}

	public Map<Liber, Boolean> getMarrHuaStatus() {
		return marrHuaStatus;
	}

	public void setMarrHuaStatus(Map<Liber, Boolean> marrHuaStatus) {
		this.marrHuaStatus = marrHuaStatus;
	}

	@Override
	public String toString() {
		return "Lexues [email=" + email + ", pasword=" + pasword + ", dataRegjistrimit=" + dataRegjistrimit + ", Emer="
				+ getEmer() + ", Mbiemer=" + getMbiemer() + "]";
	}
}