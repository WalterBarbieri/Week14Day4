package esercizio;

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
		this.price = price;
	}

	@Override
	public String toString() {
		return "[Category: " + category + ", Name: " + name + ", Price: " + price + "]";
	}

}
