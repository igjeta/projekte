package al.academy.ikubinfo.bootcamp.java.seanca11;

public class MainBankAccount {

	public static void main(String[] args) {
		BankAccount llogaria = new BankAccount(80000);

		llogaria.deposit(200);

		llogaria.withdraw(2000);

		llogaria.withdraw(100000);
		System.out.println("Balanca aktuale eshte: " + llogaria.getBalance());
	}
}