package tacos.controller;

import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.form.Order;
import tacos.repo.OrderRepository;

import javax.validation.Valid;

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
    public String processOrder(@Valid Order order, Errors errors, SessionStatus status) {
        if (errors.hasErrors()) return "orderForm";

        Order saved = orderRepo.save(order);
        log.info(String.format("Order submitted: %s", saved));

        status.setComplete();
        return "redirect:/";
    }
}
