package al.academy.ikubinfo.bootcamp.java.seanca13;

public class Ingredient {
	private String emerIngredient;
	private double kosto;

	public Ingredient(String emerIngredient, double kosto) {
		this.emerIngredient = emerIngredient;
		this.kosto = kosto;
	}

	public String getEmerIngredient() {
		return emerIngredient;
	}

	public double getKosto() {
		return kosto;
	}
}