package demo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository(value = ProductRepository.NAME)
@RepositoryRestResource(itemResourceRel = "product", path = "product")
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

	String NAME = "productRepository";
}
