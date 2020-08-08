package tacos.config;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.entity.Ingredient;
import tacos.repo.IngredientRepository;

@AllArgsConstructor
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private final IngredientRepository ingredientRepo;

  @Override
  public Ingredient convert(String id) {
    return ingredientRepo.findById(id).orElse(null);
  }

}
