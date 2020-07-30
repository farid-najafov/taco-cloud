package tacos.service;

import lombok.Value;
import org.springframework.stereotype.Service;
import tacos.form.Taco;
import tacos.repo.TacoRepository;

@Value
@Service
public class TacoService {

    TacoRepository tacoRepo;

    public Taco save(Taco taco) {
        return tacoRepo.save(taco);
    }
}
