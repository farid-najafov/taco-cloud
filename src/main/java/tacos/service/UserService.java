package tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tacos.entity.RegistrationForm;
import tacos.repo.UserRepository;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String s) {
    return userRepo.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(
        String.format("User %s is not found in our system", s)
    ));
  }

  public void saveUser(RegistrationForm form) {
    form.toUser(passwordEncoder);
  }
}
