package al.academy.ikubinfo.bootcamp.java.ushtrime;

/*
 4.	Krijoni klasën Shuma dhe deklaroni dy variabla instance/local/statik që do të ruajnë përkatësisht vlerën e të dy numrave. 

Bëni inicializimin e dy variablave me një vlerë çfarëdo dhe shfaqni rezultatin e tyre në console me mesazhin: 

Shuma e numrit të parë me vlerë: ____ dhe numrit të dytë me vlerë: ____ është ____.

-	Deklaroni një variabël që ruan vlerë true nëse keni zgjedhur dy numra të plotë dhe vlerën false nëse keni zgjedhur dy numra jo të plotë. Printoni në console vlerën që keni ruajtur në këtë variabël.

 */
public class Shuma {

	static int numriPare;
	static int numriDyte;

	public static int shumaEDyNumrave(int nr1, int nr2) {
		return nr1 + nr2;
	}

	public static void main(String[] args) {

		numriPare = 4;
		numriDyte = 6;

		System.out.println("Shuma e numrit të parë me vlerë: " + numriPare + " dhe numrit të dytë me vlerë: "
				+ numriDyte + " është " + shumaEDyNumrave(numriPare, numriDyte) + " .");

		boolean janeNumraTePlote = ((numriPare % 1 == 0) && (numriDyte % 1 == 0));

		System.out.println("A jane numra te plote? " + janeNumraTePlote);
	}

}
