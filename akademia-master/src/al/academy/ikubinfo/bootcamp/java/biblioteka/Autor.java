package al.academy.ikubinfo.bootcamp.java.biblioteka;

import java.time.LocalDate;

public class Autor extends Person {

	private LocalDate datelindje;

	public Autor(String emer, String mbiemer, LocalDate datelindje) {
		super(emer, mbiemer);
		this.datelindje = datelindje;
	}

	public LocalDate getDatelindje() {
		return datelindje;
	}

	public void setDatelindje(LocalDate datelindje) {
		this.datelindje = datelindje;
	}

	@Override
	public String toString() {
		return "Autor [datelindje=" + datelindje + ", Emer=" + getEmer() + ", Mbiemer=" + getMbiemer() + "]";
	}
}