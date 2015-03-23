package demo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository(value = CategoryRepository.NAME)
@RepositoryRestResource(itemResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {

	String NAME = "categoryRepository";

	@EntityGraph(value = "Category.detail")
	Category findOne(String id);
}
