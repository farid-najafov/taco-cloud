package tacos.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {

  @NotNull
  @Size(min = 1, message = "username is required")
  private String username;

  @NotNull
  @Size(min = 1, message = "password is required")
  private String password;

  @NotNull
  @Size(min = 1, message = "full name is required")
  private String fullName;

  @NotNull
  @Size(min = 1, message = "street is required")
  private String street;

  @NotNull
  @Size(min = 1, message = "city is required")
  private String city;

  @NotNull
  @Size(min = 1, message = "state is required")
  private String state;

  @NotNull
  @Size(min = 1, message = "zip is required")
  private String zip;

  @NotNull
  @Size(min = 1, message = "phone is required")
  private String phone;

  public User toUser(PasswordEncoder passwordEncoder) {
    return new User(
        username, passwordEncoder.encode(password),
        fullName, street, city, state, zip, phone);
  }

}
