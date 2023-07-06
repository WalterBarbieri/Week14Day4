package esercizio;

public class Customer extends Abs {
	Integer tier;

	public Customer(Long id, String name, Integer tier) {
		super(id, name);
		this.setTier(tier);

	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}
}
