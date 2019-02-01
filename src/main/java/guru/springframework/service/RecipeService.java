package guru.springframework.service;

import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 * Created by Ferenc on 1/31/2019.
 */
public interface RecipeService {
    Set<Recipe> getRecipes();
}
