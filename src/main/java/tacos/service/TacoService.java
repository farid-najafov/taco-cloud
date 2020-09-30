package tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tacos.entity.Taco;
import tacos.repo.TacoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TacoService {

  private final TacoRepository tacoRepo;

  public Taco save(Taco taco) {
    return tacoRepo.save(taco);
  }

  public List<Taco> findAll() {
    PageRequest page = PageRequest.of(
        0, 12, Sort.by("createdAt").descending());
    return tacoRepo.findAll(page).getContent();
  }

  public Optional<Taco> findById(Long id) {
    return tacoRepo.findById(id);
  }
}
