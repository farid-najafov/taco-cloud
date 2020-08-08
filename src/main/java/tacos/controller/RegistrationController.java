package tacos.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.entity.RegistrationForm;
import tacos.service.UserService;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/register")
public class RegistrationController {

  private final UserService userService;

  @ModelAttribute("reg")
  public RegistrationForm create() {
    return new RegistrationForm();
  }

  @GetMapping
  public String registerForm() {
    return "registration";
  }

  @PostMapping
  public String processRegistration(@Valid @ModelAttribute("reg") RegistrationForm form,
                                    Errors errors) {

    if (errors.hasErrors()) return "registration";

    userService.saveUser(form);
    return "redirect:/login";
  }

}
