package al.academy.ikubinfo.bootcamp.java.seanca4;

public class OperatoretLogjike {

	public static void main(String[] args) {

		boolean shprehjaPare = 25 < 24;
		boolean shprehjaDyte = (8 % 2 == 0);

		System.out.println("Numri 25 është më i vogël se numri 24 DHE numri 8 është numër çift: "
				+ (shprehjaPare && shprehjaDyte));
		System.out.println("Numri 25 është më i vogël se numri 24 OSE numri 8 është numër çift: "
				+ (shprehjaPare || shprehjaDyte));
		System.out.println("Numri 25 është më i vogël se numri 24 DHE numri 8 nuk është numër çift: "
				+ (shprehjaPare && !shprehjaDyte));
		System.out.println("Numri 25 nuk është më i vogël se numri 24 OSE numri 8 është numër çift: "
				+ (!shprehjaPare || shprehjaDyte));
		System.out.println("Numri 25 nuk është më i vogël se numri 24 DHE numri 8 nuk është numër çift: "
				+ (!shprehjaPare && !shprehjaDyte));

	}

}
