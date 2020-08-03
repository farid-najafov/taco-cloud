package tacos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tacos.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
