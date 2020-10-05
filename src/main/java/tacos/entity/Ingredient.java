package tacos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {

  @Id
  private final String id;
  private final String name;

  @Enumerated(EnumType.STRING)
  private final Type type;

  public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
