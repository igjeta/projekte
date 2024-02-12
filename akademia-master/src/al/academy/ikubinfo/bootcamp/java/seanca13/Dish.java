package al.academy.ikubinfo.bootcamp.java.seanca13;

import java.util.List;

public class Dish {
	private String emerDish;
	private List<Ingredient> ingredients;

	public Dish(String name, List<Ingredient> ingredients) {
		this.emerDish = name;
		this.ingredients = ingredients;
	}

	public String getEmerDish() {
		return emerDish;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
}
