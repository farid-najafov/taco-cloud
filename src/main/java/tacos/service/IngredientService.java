package tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tacos.entity.Ingredient;
import tacos.repo.IngredientRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class IngredientService {

  private final IngredientRepository ingRepo;

  public List<Ingredient> getAll() {
    return ingRepo.findAll();
  }

  public List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
    return ingredients
        .stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
  }

  public Ingredient getById(String id) {
    return ingRepo.getOne(id);
  }
}
