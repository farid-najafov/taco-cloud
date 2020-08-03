package tacos.controller;

import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.entity.Ingredient;
import tacos.entity.Ingredient.Type;
import tacos.entity.Order;
import tacos.entity.Taco;
import tacos.service.IngredientService;
import tacos.service.OrderService;
import tacos.service.TacoService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Value
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    IngredientService ingService;
    TacoService tacoService;
    OrderService orderService;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute
    public void design(Model model) {
        List<Ingredient> ingredients = ingService.getAll();
        Type[] types = Type.values();
        Arrays.stream(types).forEach(type ->
                model.addAttribute(type.toString().toLowerCase(),
                        ingService.filterByType(ingredients, type)));
    }

    @GetMapping
    public String showDesignForm(Model model) {
        log.info("GET -> /design");
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design,
                                Errors errors,
                                @ModelAttribute Order order) {

        if (errors.hasErrors()) return "design";

        Taco saved = tacoService.save(design);
        orderService.addDesign(saved, order);
        log.info(String.format("Processing design %s ", saved));

        return "redirect:/orders/current";
    }
}
