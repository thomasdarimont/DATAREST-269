package demo;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.NoRepositoryBean;

@Repository(value = CategoryRepository.NAME)
@RepositoryRestResource(itemResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {

    public static final String NAME = "categoryRepository";
}
