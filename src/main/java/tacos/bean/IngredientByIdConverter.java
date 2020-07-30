package tacos.bean;

import lombok.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.entity.Ingredient;
import tacos.repo.IngredientRepository;

@Value
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  IngredientRepository ingredientRepo;

  @Override
  public Ingredient convert(String id) {
    return ingredientRepo.findById(id).orElse(null);
  }

}
