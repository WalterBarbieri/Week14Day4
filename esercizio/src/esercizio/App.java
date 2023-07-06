package esercizio;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

public class App {
	static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		Faker faker = new Faker();

		List<Product> products = faker.lorem().words(100).stream().map(name -> new Product(faker.random().nextLong(),
				name, faker.commerce().department(), faker.random().nextDouble() * 100)).collect(Collectors.toList());

		log.info("**********************Lista casuale generata da faker*********************");
		products.forEach(element -> log.info("ID: " + element.getId() + " Name: " + element.getName() + " Category: "
				+ element.getCategory() + " Price: " + element.getPrice()));

		List<Product> bookProducts = products.stream().filter(prod -> prod.getCategory().equals("Books"))
				.filter(prod -> prod.getPrice() > 100).collect(Collectors.toList());

		log.info("**********************Lista books filtrata*********************");
		bookProducts.forEach(el -> log.info(el.getCategory() + " : " + el.getName() + " " + el.getPrice() + "€"));
	}
}
