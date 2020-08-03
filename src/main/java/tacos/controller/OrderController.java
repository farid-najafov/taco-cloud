package tacos.controller;

import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.entity.Order;
import tacos.entity.User;
import tacos.repo.OrderRepository;
import tacos.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Log4j2
@Value
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    OrderRepository orderRepo;

    @GetMapping("/current")
    public String orderForm() {
        log.info("GET -> /orders/current");
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order,
                               Errors errors,
                               SessionStatus status,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) return "orderForm";

        order.setUser(user);
        Order saved = orderRepo.save(order);
        log.info(String.format("Order submitted: %s", saved));

        status.setComplete();
        return "redirect:/";
    }
}
