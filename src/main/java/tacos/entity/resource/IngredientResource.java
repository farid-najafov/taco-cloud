package tacos.entity.resource;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import tacos.entity.Ingredient;

@Getter
public class IngredientResource extends RepresentationModel<IngredientResource> {

  private final String name;
  private final Ingredient.Type type;

  public IngredientResource(Ingredient ingredient) {
    this.name = ingredient.getName();
    this.type = ingredient.getType();
  }

}
