package tacos.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tacos.entity.Ingredient;
import tacos.service.IngredientService;

@RestController
@RequestMapping(path="/rest/ingredients", produces="application/json")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class IngredientControllerRest {

  private final IngredientService ingService;

  @GetMapping
  public Iterable<Ingredient> allIngredients() {
    return ingService.getAll();
  }

  @GetMapping("/{id}")
  public Ingredient getIngredientById(@PathVariable String id) {
    return ingService.getById(id);
  }
  
}
