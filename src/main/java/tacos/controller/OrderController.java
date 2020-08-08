package tacos.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.entity.Order;
import tacos.entity.User;
import tacos.service.OrderService;

import javax.validation.Valid;

@Log4j2
@AllArgsConstructor
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/current")
  public String orderForm(@AuthenticationPrincipal User user,
                          @ModelAttribute Order order) {
    log.info("GET -> /orders/current");
    if (order.getDeliveryName() == null) {
      order.setDeliveryName(user.getFullName());
    }
    if (order.getDeliveryStreet() == null) {
      order.setDeliveryStreet(user.getStreet());
    }
    if (order.getDeliveryCity() == null) {
      order.setDeliveryCity(user.getCity());
    }
    if (order.getDeliveryState() == null) {
      order.setDeliveryState(user.getState());
    }
    if (order.getDeliveryZip() == null) {
      order.setDeliveryZip(user.getZip());
    }
    return "orderForm";
  }

  @PostMapping
  public String processOrder(@Valid @ModelAttribute("order") Order order,
                             Errors errors,
                             SessionStatus status,
                             @AuthenticationPrincipal User user) {
    if (errors.hasErrors()) return "orderForm";

    order.setUser(user);
    Order saved = orderService.save(order);
    log.info(String.format("Order submitted: %s", saved));

    status.setComplete();
    return "redirect:/";
  }

  @GetMapping
  public String orderList(@AuthenticationPrincipal User user, Model model) {

    model.addAttribute("orders", orderService.findAndSort(user));
    return "orderList";
  }
}
