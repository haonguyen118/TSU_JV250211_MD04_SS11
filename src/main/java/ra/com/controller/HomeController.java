package ra.com.controller;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home(Model model) {
        return "home";
    }
}
