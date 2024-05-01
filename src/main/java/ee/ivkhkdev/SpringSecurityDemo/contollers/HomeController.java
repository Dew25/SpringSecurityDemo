package ee.ivkhkdev.SpringSecurityDemo.contollers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Arrays;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        // Получаем объект аутентификации из контекста безопасности
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Проверяем, что пользователь аутентифицирован
        if (authentication != null && authentication.isAuthenticated()) {
            Object credentials = authentication.getCredentials();
            if (credentials != null) {
                model.addAttribute("password",credentials.toString());
            }else{
                model.addAttribute("password","Пароль = null");
            }
            model.addAttribute("username",authentication.getName());
            model.addAttribute("roles", Arrays.toString(authentication.getAuthorities().toArray()));
        }
        model.addAttribute("info", "Hello JKTV22");
        return "index";
    }
    @GetMapping("user")
    public String user(Model model,Authentication authentication){
        model.addAttribute("info","Hello User JKTV22");
        System.out.println((UserDetails)authentication.getPrincipal());
        return "user";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("info","Hello Admin JKTV22");
        return "admin";
    }
}
