package demo;

import java.lang.String;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Category {

    @Id
    private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", nullable = true, referencedColumnName = "id")
	private Product product;

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
