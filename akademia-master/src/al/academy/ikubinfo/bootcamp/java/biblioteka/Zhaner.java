package al.academy.ikubinfo.bootcamp.java.biblioteka;

public enum Zhaner {
	ROMAN("Roman", 1500), FILOZOFI("Filozofi", 1700), BIOGRAFI("Biografi", 1750), HISTORI("Histori", 1800),
	PSIKOLOGJI("Psikologji", 2000);

	private String titulli;
	private int vitLindje;

	Zhaner(String titulli, int vitLindje) {
		this.titulli = titulli;
		this.vitLindje = vitLindje;
	}

	public String getTitulli() {
		return this.titulli;
	}

	public int getVitLindje() {
		return this.vitLindje;
	}
}
