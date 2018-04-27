package com.jwt.oauth2.springbootoauth2jwt.custom;

import com.jwt.oauth2.springbootoauth2jwt.entity.Roles;
import com.jwt.oauth2.springbootoauth2jwt.entity.Users;
import com.jwt.oauth2.springbootoauth2jwt.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomUserDetails implements UserDetailsService{

    private final Logger logActivity = LoggerFactory.getLogger(CustomUserDetails.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        logActivity.debug("proses authentication user {} ", login);
        String lowerCaseLogin = login.toLowerCase();

        Users entityUsers;
        if(lowerCaseLogin.contains("@")){
            entityUsers = usersRepository.findByEmail(lowerCaseLogin);
        }else{
            entityUsers = usersRepository.findByUsernameCaseSensitive(lowerCaseLogin);
        }

        if(entityUsers == null){
            throw new CustomUserNotActiveException("Maaf user "+lowerCaseLogin+" tidak ditemukan");
        }else if(!entityUsers.isActivated()){
            throw new CustomUserNotActiveException("Maaf user "+lowerCaseLogin+" tidak active");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Roles roles : entityUsers.getRolesList()){
            GrantedAuthority authority = new SimpleGrantedAuthority(roles.getName());
            grantedAuthorities.add(authority);
        }

        return new User(entityUsers.getUsername(),entityUsers.getPassword(),grantedAuthorities);
    }
}
