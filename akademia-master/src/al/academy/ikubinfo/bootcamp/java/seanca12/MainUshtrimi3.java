package al.academy.ikubinfo.bootcamp.java.seanca12;

public class MainUshtrimi3 {
	public static void main(String[] args) {
		Katror katror = new Katror(4);
		Drejtkendesh drejtkendesh = new Drejtkendesh(4, 6);
		Trekendesh trekendesh = new Trekendesh(3, 5, 2, 2, 4); // baza,lartesi,brinja2,brinja3,lloji
		Rreth rreth = new Rreth(2);

		System.out.println(katror.toString());
		System.out.println(drejtkendesh.toString());
		System.out.println(trekendesh.toString());
		System.out.println(rreth.toString());
	}
}
