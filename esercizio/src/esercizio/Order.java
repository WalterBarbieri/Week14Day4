package esercizio;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order extends Abs {
	static Logger log = LoggerFactory.getLogger(App.class);
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("OrderID: ").append(id);
		sb.append(", Status: ").append(status);
		sb.append(", Data Ordine: ").append(orderDate);
		sb.append(", Data Consegna: ").append(deliveryDate);
		sb.append(", Cliente: ").append(customer.getName());
		sb.append(", Prodotti: ").append(products.toString());
		return sb.toString();
	}

}
