package tacos.entity.resource;

import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import tacos.entity.Taco;

import java.util.Date;

@Getter
@Relation(value="taco", collectionRelation="tacos")
public class TacoResource extends RepresentationModel<TacoResource> {

  private static final IngredientResourceAssembler ingredientAssembler =
      new IngredientResourceAssembler();

  private final String name;
  private final Date createdAt;
  private final CollectionModel<IngredientResource> ingredients;

  public TacoResource(Taco taco) {
    this.name = taco.getName();
    this.createdAt = taco.getCreatedAt();
    this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
  }

}
