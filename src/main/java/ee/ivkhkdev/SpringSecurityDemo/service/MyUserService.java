package ee.ivkhkdev.SpringSecurityDemo.service;

import ee.ivkhkdev.SpringSecurityDemo.entity.MyUser;
import ee.ivkhkdev.SpringSecurityDemo.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {
    @Autowired
    private PasswordEncoder passwordEcoder;

    @Autowired
    private MyUserRepository myUserRepository;
    public void registration(MyUser myUser){
        myUser.setPassword(passwordEcoder.encode(myUser.getPassword()));
        myUserRepository.save(myUser);
    }

    public List<MyUser> allUsers(){
        return myUserRepository.findAll();
    }
}
