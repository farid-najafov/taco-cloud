package tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tacos.entity.Order;
import tacos.entity.Taco;
import tacos.entity.User;
import tacos.repo.OrderRepository;
import tacos.util.OrderProps;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

  private final OrderRepository orderRepo;
  private final OrderProps orderProps;


  public void addDesign(Taco design, Order order) {
    order.getTacos().add(design);
  }

  public Order save(Order order) {
    return orderRepo.save(order);
  }

  public List<Order> findAndSort(User user) {
    Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
    return orderRepo.findByUserOrderByPlacedAtDesc(user, pageable);
  }
}
