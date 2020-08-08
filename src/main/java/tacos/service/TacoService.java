package tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tacos.entity.Taco;
import tacos.repo.TacoRepository;

@AllArgsConstructor
@Service
public class TacoService {

  private final TacoRepository tacoRepo;

  public Taco save(Taco taco) {
    return tacoRepo.save(taco);
  }
}
