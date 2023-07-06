package Lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class App {

	public static void main(String[] args) {

		System.out.println("----------Lambda Thread-------------");

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <= 10; i++) {
					System.out.println(Thread.currentThread().getName() + " I: " + i);
				}

			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + " I: " + i);
			}
		}).start();

		StringModifier wrapper = s -> "* * *" + s + "* * *";
		StringModifier inverter = s -> {
			String[] c = s.split("");
			String inverted = "";
			for (int i = c.length - 1; i >= 0; i--) {
				inverted += c[i];
			}
			return inverted;
		};
		System.out.println("----------------Lambda Wrapper e Inverter--------------------");
		System.out.println(wrapper.modify("Ciao"));
		System.out.println(inverter.modify("Ciao"));

		System.out.println("--------------Lambda Predicate-------------------");

		Random rnd = new Random();

		Human aldo = new Human("Aldo", "Baglio", 20, rnd.nextInt());

		Predicate<Integer> isMoreThanZero = n -> n > 0;
		Predicate<Integer> isLessThanHundred = n -> n < 100;
		System.out.println(isMoreThanZero.test(aldo.getAge()));
		System.out.println(isLessThanHundred.test(aldo.getAge()));
		Predicate<Integer> isBetweenZeroAndHundred = isMoreThanZero.and(isLessThanHundred);
		System.out.println(isBetweenZeroAndHundred.test(aldo.getAge()));
		System.out.println(isMoreThanZero.negate().test(aldo.getAge()));

		System.out.println("------------Lambda Supplier------------------");

//		Supplier<Human> humanSupplier = () -> {
//			return new Human("Mangia", "Banane", 92, rnd.nextInt());
//		};
		Faker f = new Faker();

		Supplier<Human> humanSupplier = () -> {
			return new Human(f.harryPotter().character(), f.harryPotter().house(), rnd.nextInt(100),
					rnd.nextInt(100000));
		};
		List<Human> humans = new ArrayList<Human>();
		for (int i = 0; i < 100; i++) {
			humans.add(humanSupplier.get());
		}
		humans.forEach(human -> System.out.println(human.getId() + " Nome: " + human.getName() + " Casa: "
				+ human.getSurname() + " Età: " + human.getAge()));

		Supplier<Integer> intSupplier = () -> {
			return rnd.nextInt(1, 100);

		};

		List<Integer> interi = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			interi.add(intSupplier.get());
		}

		interi.forEach(i -> System.out.println(i));

		System.out.println("------------Lambda Stream----------------");

		Stream<Human> humansStream = humans.stream().limit(10);
		humansStream.forEach(s -> System.out.println(s.getName() + " " + s.getSurname()));

		List<Integer> interi2 = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			interi2.add(intSupplier.get());
		}

		Predicate<Integer> isLessThan20 = n -> n < 20;
		Predicate<Integer> isGreaterThan10 = n -> n > 10;

		List<Integer> filteredList = interi2.stream().filter(isGreaterThan10.and(isLessThan20)).toList();
		filteredList.forEach(i -> System.out.println(i));

		List<String> mappedNumbers = filteredList.stream().map(num -> "Numero: " + num).toList();
		mappedNumbers.forEach(el -> System.out.println(el));

		System.out.println("----------Local Date-----------");

		LocalDate today = LocalDate.now();
		System.out.println(today);

		LocalDate tomorrow = today.plusDays(1);
		System.out.println(tomorrow);

		LocalDate yesterday = today.minusDays(1);
		System.out.println(yesterday);

		System.out.println(yesterday.isBefore(today));

	}

}
