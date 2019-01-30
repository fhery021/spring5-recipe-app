package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ferenc on 1/31/2019.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>{
}
