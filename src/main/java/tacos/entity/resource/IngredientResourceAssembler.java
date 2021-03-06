package tacos.entity.resource;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacos.entity.Ingredient;
import tacos.rest.IngredientControllerRest;

public class IngredientResourceAssembler
    extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

  public IngredientResourceAssembler() {
    super(IngredientControllerRest.class, IngredientResource.class);
  }

  @Override
  protected IngredientResource instantiateModel(Ingredient entity) {
    return new IngredientResource(entity);
  }

  @Override
  public IngredientResource toModel(Ingredient entity) {
    return createModelWithId(entity.getId(), entity);
  }
}
