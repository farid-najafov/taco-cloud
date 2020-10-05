package tacos.rest;

import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tacos.entity.Taco;
import tacos.entity.resource.TacoResource;
import tacos.entity.resource.TacoResourceAssembler;
import tacos.service.TacoService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
@AllArgsConstructor
public class RecentTacosController {

  private final TacoService tacoService;

  @GetMapping(path = "tacos/recent", produces = "application/hal+json")
  public ResponseEntity<CollectionModel<TacoResource>> recentTacos() {
    List<Taco> tacoList = tacoService.findAll();

    CollectionModel<TacoResource> tacoResources =
        new TacoResourceAssembler().toCollectionModel(tacoList);

    tacoResources.add(linkTo(methodOn(this.getClass()).recentTacos()).withRel("recent tacos"));

    return new ResponseEntity<>(tacoResources, HttpStatus.OK);
  }
}
