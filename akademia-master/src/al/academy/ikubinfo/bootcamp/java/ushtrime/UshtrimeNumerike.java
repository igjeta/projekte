package al.academy.ikubinfo.bootcamp.java.ushtrime;

/*
 5.	Krijoni klasën UshtrimeNumerike, brenda metodës main të së cilës deklaroni 2 variabla lokal që ruajnë përkatësisht një numër të plotë dhe një numër me presje.

Numri i parë ka vlerën 50
Numri i dytë jepini vlerën 20.9

a)	Printoni vlerat përkatëse në console
b)	 Dy numrave Përdorni tre variabla që ruajnë përkatësisht: shumën, diferencë dhe produktin e ketyre numrave
c)	. Vlerat të shfaqen në console.
d)	Shtoni vlerën 0.1 te numri i dytë dhe shfaqni rezultatin në console.
e)	Vlerën e re që kemi te numri i dytë vendoseni si vlerë të variabli i parë. Trego pse kodi kompilohet me sukses ose pa sukses?

 */
public class UshtrimeNumerike {

	public static void main(String[] args) {

		int numriPare = 50;
		double numriDyte = 20.9;

		System.out.println("Vlera e numrit te pare eshte " + numriPare + " ndersa vlera e numrit te dyte eshte "
				+ numriDyte + " .");

		double shumaEDyNumrave = numriPare + numriDyte;
		double diferencaEDyNumrave = numriPare - numriDyte;
		double produktiIDyNunmrave = numriPare * numriDyte;

		System.out.println("Per dy numrat e dhene ku numri i pare eshte " + numriPare + " dhe numri i dyte eshte "
				+ numriDyte + ", shuma e tyre eshte " + shumaEDyNumrave + " difernca e tyre eshte "
				+ diferencaEDyNumrave + " nersa produkti i tyre eshte " + produktiIDyNunmrave + " .");

		numriDyte += 0.1;

		System.out.println(numriDyte);

		/*
		 * numriPare=numriDyte; vendosja e vleres se numrit te dyte tek numri i pare ne
		 * rastin tim sjell error ne kompilim sepse tipi i numrit te pare eshte int
		 * ndersa tipi e numrit te dyte eshte double dhe nuk mund ti mbishkruhet pasi
		 * jane tipe te ndyshme 
		 * numriPare= (int) numriDyte; nje menyre zgjidhje
		 */

	}

}
