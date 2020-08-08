package tacos.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Log4j2
@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final static String[][] mappings = {
      {"/", "home"},
      {"/login", "login"}
  };

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    Arrays.stream(mappings).forEach(m ->
        registry.addViewController(m[0]).setViewName(m[1])
    );
  }
}
