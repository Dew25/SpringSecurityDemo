package ee.ivkhkdev.SpringSecurityDemo.service;

import ee.ivkhkdev.SpringSecurityDemo.entity.MyUser;
import ee.ivkhkdev.SpringSecurityDemo.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ee.ivkhkdev.SpringSecurityDemo.security.MyUserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = myUserRepository.findByUsername(username);
        return myUser.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(username+ " not found"));
    }
}
