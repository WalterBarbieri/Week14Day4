package esercizio;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Product extends Abs {
	String category;
	Double price;

	public Product(Long id, String name, String category, Double price) {
		super(id, name);
		this.setCategory(category);
		this.setPrice(price);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.getDefault());
		DecimalFormat formattedPrice = new DecimalFormat("#.##", symbols);
		formattedPrice.setRoundingMode(RoundingMode.HALF_UP);
		String formattedPriceString = formattedPrice.format(price);
		formattedPriceString = formattedPriceString.replace(',', '.');

		this.price = Double.parseDouble(formattedPriceString);
	}

	@Override
	public String toString() {
		return "[Category: " + category + ", Name: " + name + ", Price: " + price + "€]";
	}

}
