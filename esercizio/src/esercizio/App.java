package esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

public class App {
	static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		Faker faker = new Faker();
		Random rnd = new Random();
		List<String> categories = List.of("Books", "Babys", "Boys");

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

		List<Order> orders = genRandomOrders(products, customers);
		orders.forEach(ord -> log.info("OrderID: " + ord.getId() + " Status: " + ord.getStatus() + " Data Ordine: "
				+ ord.getOrderDate() + " Data Consegna: " + ord.getDeliveryDate() + " Cliente: " + ord.getCustomer()
				+ " Prodotti: " + ord.getProducts()));

	}

	private static List<Order> genRandomOrders(List<Product> products, List<Customer> customers) {
		Faker faker = new Faker();
		Random rnd = new Random();

		List<Order> orders = new ArrayList<>();

		List<String> statuses = List.of("Pending", "Ready", "Dispatched");

		List<Product> babyProducts = products.stream().filter(prod -> prod.getCategory().equals("Baby"))
				.collect(Collectors.toList());

		for (int i = 0; i < 10; i++) {
			String status = statuses.get(rnd.nextInt(statuses.size()));
			LocalDate orderDate = LocalDate.now();
			LocalDate deliveryDate = orderDate.plusDays(rnd.nextInt(7) + 1);
			Customer rndCustomer = customers.get(rnd.nextInt(customers.size()));

//			List<Product> rndBabyProducts = babyProducts.subList(genRandomIndex(babyProducts),
//					(genRandomIndex(babyProducts) + 10));
			Order order = new Order(faker.random().nextLong(), status, orderDate, deliveryDate, babyProducts,
					rndCustomer);
			orders.add(order);
		}
		return orders;

	}

//	private static int genRandomIndex(List<Product> products) {
//		Random rnd = new Random();
//		if (products.size() > 10) {
//			int rndIndex = rnd.nextInt(products.size() - 10);
//			if (rndIndex >= 0) {
//				return rndIndex;
//			} else {
//				return 0;
//			}
//
//		} else
//			return 0;
//
//	}
}
