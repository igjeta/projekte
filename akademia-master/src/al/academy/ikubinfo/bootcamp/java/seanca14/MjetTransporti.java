package al.academy.ikubinfo.bootcamp.java.seanca14;

public class MjetTransporti {
	private LlojiMjetit lloji;
	private String targa;

	public MjetTransporti(LlojiMjetit lloji, String targa) {
        this.lloji = lloji;
        this.targa = targa;
    }

    public LlojiMjetit getLloji() {
        return lloji;
    }

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		targa = targa;
	}
}