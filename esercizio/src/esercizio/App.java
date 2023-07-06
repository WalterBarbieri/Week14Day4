package esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

public class App {
	static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		Faker faker = new Faker();
		Random rnd = new Random();
		List<String> categories = List.of("Books", "Baby", "Boys");

		log.info("**********************Lista Prodotti Random*********************");
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			String name = faker.pokemon().name();
			String category = categories.get(rnd.nextInt(categories.size()));
			double price = 50.00 + rnd.nextDouble() * 500.00;
			Product product = new Product(faker.random().nextLong(), name, category, price);
			products.add(product);
		}

		products.forEach(element -> log.info("ID: " + element.getId() + " Name: " + element.getName() + " Category: "
				+ element.getCategory() + " Price: " + element.getPrice()));

		log.info("################################################################");
		log.info("**********************Lista Books>100€ filtrata*********************");
		List<Product> bookProducts = products.stream().filter(prod -> prod.getCategory().equals("Books"))
				.filter(prod -> prod.getPrice() > 100).collect(Collectors.toList());

		bookProducts.forEach(el -> log.info(el.getCategory() + " : " + el.getName() + " " + el.getPrice() + "€"));
		log.info("################################################################");
		log.info("**********************Lista Customer Random*********************");
		List<Customer> customers = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			String name = faker.dragonBall().character();
			Integer tier = rnd.nextInt(3) + 1;
			Customer customer = new Customer(faker.random().nextLong(), name, tier);
			customers.add(customer);
		}

		customers.forEach(element -> log
				.info("ID: " + element.getId() + " Name: " + element.getName() + " Tier: " + element.getTier()));

		log.info("################################################################");
		log.info("------------------------Lista Order Random----------------------");

		List<Order> babyOrders = genRandomOrders(products, customers, "Baby");
		babyOrders.forEach(ord -> {
			log.info(ord.toString());
		});

		log.info("################################################################");
		log.info("------------------------Lista Boys + 10% Discount----------------------");

		List<Product> boysProducts = products.stream().filter(prod -> prod.getCategory().equals("Boys"))
				.collect(Collectors.toList());

		boysProducts
				.forEach(el -> log.info(el.getCategory() + " : " + el.getName() + " " + (el.getPrice() * 0.9) + "€"));

		log.info("################################################################");
		log.info("------------------------Lista Prodotti Ordinati da clienti tier 2 con data----------------------");

		Predicate<Order> timeRange = order -> order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1))
				&& order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1));

		List<Order> boysOrder = genRandomOrders(products, customers, "Boys").stream()
				.filter(ord -> ord.getCustomer().getTier() == 2).filter(timeRange).collect(Collectors.toList());

		boysOrder.forEach(ord -> {
			log.info(ord.toString());
		});
	}

	private static List<Order> genRandomOrders(List<Product> products, List<Customer> customers, String category) {
		Faker faker = new Faker();
		Random rnd = new Random();

		List<Order> orders = new ArrayList<>();

		List<String> statuses = List.of("Pending", "Ready", "Dispatched");

		List<Product> babyProducts = products.stream().filter(prod -> prod.getCategory().equals(category))
				.collect(Collectors.toList());

		int productListSize = babyProducts.size();

		for (int i = 0; i < 50; i++) {
			String status = statuses.get(rnd.nextInt(statuses.size()));
			LocalDate orderDate = LocalDate.of(2021, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1);
			LocalDate deliveryDate = orderDate.plusDays(rnd.nextInt(7) + 1);
			Customer rndCustomer = customers.get(rnd.nextInt(customers.size()));

			int startIndex = rnd.nextInt(productListSize - 5);
			int endIndex = startIndex + 5;
			List<Product> rndBabyProducts = babyProducts.subList(startIndex, endIndex);
			Order order = new Order(faker.random().nextLong(), status, orderDate, deliveryDate, rndBabyProducts,
					rndCustomer);
			orders.add(order);
		}
		return orders;

	}

}
