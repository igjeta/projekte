package al.academy.ikubinfo.bootcamp.java.seanca13;

public class Customer {

	private String nid;
	private int nrKontakti;
	private String adresa;
	private String emer;
	private String mbiemer;

	public Customer(String nid, int nrKontakti, String adresa, String emer, String mbiemer) {
		this.nid = nid;
		this.nrKontakti = nrKontakti;
		this.adresa = adresa;
		this.emer = emer;
		this.mbiemer = mbiemer;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public int getNrKontakti() {
		return nrKontakti;
	}

	public void setNrKontakti(int nrKontakti) {
		this.nrKontakti = nrKontakti;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmer() {
		return emer;
	}

	public void setEmer(String emer) {
		this.emer = emer;
	}

	public String getMbiemer() {
		return mbiemer;
	}

	public void setMbiemer(String mbiemer) {
		this.mbiemer = mbiemer;
	}
}