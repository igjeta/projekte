package al.academy.ikubinfo.bootcamp.java.seanca11;

public class BankAccount {

	private double balanca;

	public BankAccount(double balanca) {
		super();
		this.balanca = balanca;
	}

	public void deposit(double shuma) {
		balanca += shuma;
	}

	public void withdraw(double shuma) {
		if (shuma <= balanca) {
			balanca -= shuma;
			System.out.println("Shuma e terhequr eshte : " + shuma
					+ " .Balanca e aktuale mbas veprimit withdraw eshte : " + balanca);
		} else {
			System.out.println(
					"Veprimi nuk mund te kryhet pasi shuma qe doni te terhiqni eshte me e madhe se balanca aktuale :"
							+ balanca);
		}
	}

	public double getBalance() {
		return balanca;
	}

}
