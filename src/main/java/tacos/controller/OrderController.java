package tacos.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.form.Order;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/orders")
public class OrderController {

    private static String fmt(String format, Object... args) {
        return String.format(format, args);
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        log.info("GET -> /orders/current");
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) return "orderForm";
        log.info(fmt("Order submitted: %s", order));
        return "redirect:/";
    }

}
