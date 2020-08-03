package tacos.service;

import lombok.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tacos.repo.UserRepository;

@Value
@Service
public class UserService implements UserDetailsService {

    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) {
        return userRepo.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User %s is not found in our system", s)
        ));
    }

}
