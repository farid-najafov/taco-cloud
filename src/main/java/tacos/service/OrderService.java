package tacos.service;

import lombok.Value;
import org.springframework.stereotype.Service;
import tacos.form.Order;
import tacos.form.Taco;
import tacos.repo.OrderRepository;

@Value
@Service
public class OrderService {

    OrderRepository orderRepo;

    public void addDesign(Taco design, Order order) {
        order.getTacos().add(design);
    }
}
