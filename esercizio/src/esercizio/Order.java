package esercizio;

import java.time.LocalDate;
import java.util.List;

public class Order extends Abs {
	String status;
	LocalDate orderDate;
	LocalDate deliveryDate;
	List<Product> products;
	Customer customer;

	public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
			Customer customer) {
		super(id);
		this.setStatus(status);
		this.setOrderDate(orderDate);
		this.setDeliveryDate(deliveryDate);
		this.setProducts(products);
		this.setCustomer(customer);

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
