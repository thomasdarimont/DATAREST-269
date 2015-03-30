package demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Category {

	@Id private String id;

	@ManyToOne(fetch = FetchType.LAZY)//
	@JoinColumn(name = "product", nullable = true, referencedColumnName = "id")//
	private Product product;

	public Category() {}

	public Category(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
