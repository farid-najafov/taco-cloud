package tacos.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tacos.config.SecurityConfig;
import tacos.repo.IngredientRepository;
import tacos.repo.OrderRepository;
import tacos.repo.TacoRepository;
import tacos.repo.UserRepository;
import tacos.util.DiscountCodeProps;
import tacos.util.OrderProps;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class WebConfigTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DesignTacoController designTacoController;
    @MockBean
    DiscountController discountController;
    @MockBean
    OrderController orderController;
    @MockBean
    RegistrationController registrationController;

    @Test
    void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(content().string(
                containsString("Welcome to...")));
    }
}