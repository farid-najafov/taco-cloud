package tacos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tacos.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
