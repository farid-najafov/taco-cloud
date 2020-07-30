package tacos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tacos.form.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
