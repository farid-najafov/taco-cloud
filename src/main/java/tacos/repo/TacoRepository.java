package tacos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tacos.entity.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
