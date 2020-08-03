package tacos.controller;
import lombok.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.entity.RegistrationForm;
import tacos.repo.UserRepository;

@Value
@Controller
@RequestMapping("/register")
public class RegistrationController {
  
  UserRepository userRepo;
  PasswordEncoder passwordEncoder;
  
  @GetMapping
  public String registerForm() {
    return "registration";
  }

  @PostMapping
  public String processRegistration(RegistrationForm form) {
    userRepo.save(form.toUser(passwordEncoder));
    return "redirect:/login";
  }

}
