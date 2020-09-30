package tacos.entity.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import tacos.entity.Taco;

//@Configuration
//public class SpringDataRestConfiguration {
//
//  @Bean
//  public RepresentationModelProcessor<CollectionModel<EntityModel<Taco>>> tacoProcessor(EntityLinks links) {
//
//    return model -> {
//      model.add(
//          links.linkFor(Taco.class)
//              .slash("recent")
//              .withRel("recent tacos"));
//      return model;
//    };
//  }
//
//}
