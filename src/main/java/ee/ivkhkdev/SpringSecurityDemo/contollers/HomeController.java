package ee.ivkhkdev.SpringSecurityDemo.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("info","Главная страница");
        model.addAttribute("hello","Hello SKTV22");
        return "index";
    }
    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("info","Страница пользователя");
        model.addAttribute("hello","Hello User SKTV22");
        return "user";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("info","Страница администратора");
        model.addAttribute("hello","Hello Admin SKTV22");
        return "admin";
    }
}
