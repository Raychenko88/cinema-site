package org.example.service.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.model.UserRole;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Qualifier("userDetails")
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;


    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);
        Set<GrantedAuthority> roles = new HashSet();
        if (user.getLogin().equals("admin")) {
            roles.add(new SimpleGrantedAuthority(UserRole.USER.getName()));
            roles.add(new SimpleGrantedAuthority(UserRole.ADMIN.getName()));
            UserDetails userDetails =
                    new org.springframework.security.core.userdetails.User(user.getLogin(),
                            user.getPassword(),
                            roles);
            return userDetails;
        }
        roles.add(new SimpleGrantedAuthority(UserRole.USER.getName()));
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(),
                        user.getPassword(),
                        roles);
        return userDetails;
    }
}
