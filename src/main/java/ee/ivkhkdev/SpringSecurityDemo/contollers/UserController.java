package ee.ivkhkdev.SpringSecurityDemo.contollers;

import ee.ivkhkdev.SpringSecurityDemo.entity.MyUser;
import ee.ivkhkdev.SpringSecurityDemo.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class UserController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("info","Hello User SKTV22");
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(
            Model model,
            @RequestParam String username,
            @RequestParam String password){
        MyUser myUser = new MyUser();
        myUser.setUsername(username);
        myUser.setPassword(passwordEncoder.encode(password));
        myUser.getRoles().add("USER");
        myUserRepository.save(myUser);
        model.addAttribute("info","Добавлен пользователь "+myUser.getUsername());
        return "redirect:/";
    }
}
