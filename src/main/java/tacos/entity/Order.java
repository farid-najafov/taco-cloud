package tacos.entity;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "T_Order")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 1, message = "Name is required")
  private String deliveryName;

  @NotNull
  @Size(min = 1, message = "Street is required")
  private String deliveryStreet;

  @NotNull
  @Size(min = 1, message = "City is required")
  private String deliveryCity;

  @NotNull
  @Size(min = 1, message = "State is required")
  private String deliveryState;

  @NotNull
  @Size(min = 1, message = "Zip is required")
  private String deliveryZip;

  @CreditCardNumber(message = "Not a valid credit card number. e.g 79927398713")
  private String ccNumber;

  @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
      message = "Must be formatted MM/YY")
  private String ccExpiration;

  @Size(min = 3, max = 3, message = "Invalid CVV")
  private String ccCVV;

  @ManyToMany(targetEntity = Taco.class)
  private List<Taco> tacos = new ArrayList<>();

  @ManyToOne
  private User user;

  private Date placedAt;

  @PrePersist
  public void placedAt() {
    this.placedAt = new Date();
  }

}
