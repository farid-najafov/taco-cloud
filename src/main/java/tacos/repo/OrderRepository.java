package tacos.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tacos.entity.Order;
import tacos.entity.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
