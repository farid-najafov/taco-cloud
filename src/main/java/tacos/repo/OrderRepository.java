package tacos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tacos.form.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
