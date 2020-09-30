package tacos.rest;


import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.entity.Taco;
import tacos.entity.resource.TacoResource;
import tacos.entity.resource.TacoResourceAssembler;
import tacos.service.TacoService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/rest/design", produces = "application/json")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class DesignTacoControllerRest {

  private final TacoService tacoService;

//  @GetMapping("recent")
//  public CollectionModel<EntityModel<Taco>> recentTacos() {
//
//    List<Taco> tacoList = tacoService.findAll();
//
//    CollectionModel<EntityModel<Taco>> recentTacos = CollectionModel.wrap(tacoList);
//
//    // V1
////    recentTacos.add(Link.of("http://localhost:8080/rest/design/recent", "recents"));
//
//    // V2
////    recentTacos.add(
////        linkTo(DesignTacoControllerRest.class)
////            .slash("recent")
////            .withRel("recent tacos"));
//
//    // V3
//    recentTacos.add(linkTo(methodOn(this.getClass()).recentTacos()).withRel("recent tacos"));
//
//    return recentTacos;
//  }

  @GetMapping(path = "recent", produces = "application/hal+json")
  public CollectionModel<TacoResource> recentTacos() {


    List<Taco> tacoList = tacoService.findAll();

    CollectionModel<TacoResource> tacoResources = new TacoResourceAssembler()
        .toCollectionModel(tacoList);

    tacoResources.add(linkTo(methodOn(this.getClass()).recentTacos()).withRel("recent tacos"));

    return tacoResources;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
    Optional<Taco> optTaco = tacoService.findById(id);

    return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
  }

  @PostMapping(consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public Taco postTaco(@RequestBody Taco taco) {
    return tacoService.save(taco);
  }
}
