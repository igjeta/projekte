package al.academy.ikubinfo.bootcamp.java.seanca12;

public class Cilinder extends Rreth{
	
	private double lartesi;

    public Cilinder() {
        super(1.0,"blu"); 
        this.lartesi = 1.0;
    }

    public Cilinder(double rreze, String ngjyre, double lartesi) {
        super(rreze, ngjyre); 
        this.lartesi = lartesi;
    }

    public double getLartesi() {
        return lartesi;
    }

    public void setLartesi(double lartesi) {
        this.lartesi = lartesi;
    }

	public double vellimiCilindrit() {
        return siperfaqjaRrethit() * lartesi;
    }


}
