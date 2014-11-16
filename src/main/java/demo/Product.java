package demo;

import java.lang.String;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
	private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
