package demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id private String id;

	public Product() {}

	public Product(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
