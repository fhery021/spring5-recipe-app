package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ferenc on 1/31/2019.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
