package al.academy.ikubinfo.bootcamp.java.seanca5;

public class SeriaNumrave {

	public static void main(String[] args) {

		double shuma=1;
		double n=4;
		
		while(n<1606) {
			shuma=shuma+(1/n);
			n=n*2;
		}
		System.out.println("Shuma e serise eshte "+shuma);
		
	}

}
