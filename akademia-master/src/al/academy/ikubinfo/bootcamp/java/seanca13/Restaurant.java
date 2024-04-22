package al.academy.ikubinfo.bootcamp.java.seanca13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

	private List<Order> orders;
	private List<Dish> dishes;

	public Restaurant() {
		orders = new ArrayList<>();
		dishes = new ArrayList<>();
	}

	public void vendosPorosi(Customer customer) {
		Order order = new Order(dishes, customer);
		orders.add(order);
	}

	public List<Order> merrPorosiTeCustomer(Customer customer) {
		List<Order> customerOrders = new ArrayList<>();
		for (Order order : orders) {
			if (order.getCustomer().equals(customer)) {
				customerOrders.add(order);
			}
		}
		return customerOrders;
	}

	public List<Dish> merrDishTeCustomer(Customer customer) {
		List<Dish> customerDishes = new ArrayList<>();
		for (Order order : orders) {
			if (order.getCustomer().equals(customer)) {
				customerDishes.addAll(order.getDishes());
			}
		}
		return customerDishes;
	}

	public Customer shfaqCustomersTePorosise(Order order) {
		return order.getCustomer();
	}

	public Order shfaqPorosineMeTeShtrenjte() {
		if (orders.isEmpty()) {
			return null;
		}

		Order porosiaMeEShtrenjte = null;
		double kostoMaksimale = porosiaMeEShtrenjte.llogaritKostonTotale();

		for (Order order : orders) {
			double kostoAktuale = order.llogaritKostonTotale();
			if (kostoAktuale > kostoMaksimale) {
				porosiaMeEShtrenjte = order;
				kostoMaksimale = kostoAktuale;
			}
		}

		return porosiaMeEShtrenjte;
	}

}
