package al.academy.ikubinfo.bootcamp.java.seanca13;

import java.util.List;

public class Order {

	private List<Dish> dishes;
	private Customer customer;

	public Order(List<Dish> dishes, Customer customer) {
		this.dishes = dishes;
		this.customer = customer;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double llogaritKostonTotale() {
		double kostoTotale = 0.0;
		for (Dish dish : dishes) {
			for (Ingredient ingredient : dish.getIngredients()) {
				kostoTotale += ingredient.getKosto();
			}
		}
		return kostoTotale;
	}
}
