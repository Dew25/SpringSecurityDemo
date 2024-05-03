package ee.ivkhkdev.SpringSecurityDemo.config;

import ee.ivkhkdev.SpringSecurityDemo.entity.MyUser;
import ee.ivkhkdev.SpringSecurityDemo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminConfig {
    @Autowired
    private MyUserService myUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public CommandLineRunner insertSuperUser() {
        return args -> {
            if (!(myUserService.allUsers().size() > 0)) {
                MyUser admin = new MyUser();
                admin.getRoles().add("ADMIN");
                admin.getRoles().add("MANAGER");
                admin.getRoles().add("USER");
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("12345"));
                myUserService.save(admin);
            }
        };
    }
}
