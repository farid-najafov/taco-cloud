package tacos.entity.resource;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacos.entity.Taco;
import tacos.rest.DesignTacoControllerRest;

public class  TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

  public TacoResourceAssembler() {
    super(DesignTacoControllerRest.class, TacoResource.class);
  }

  @Override
  protected TacoResource instantiateModel(Taco entity) {
    return new TacoResource(entity);
  }

  @Override
  public TacoResource toModel(Taco entity) {
    return createModelWithId(entity.getId(), entity);
  }
}
