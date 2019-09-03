package com.store.app.service;

import com.store.app.entity.AppRole;
import com.store.app.entity.AppUser;
import com.store.app.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @NonNull
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUserName(userName);
        log.info("Found user:{}", appUser);
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        for(AppRole role : appUser.getRoles()) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            grantList.add(authority);
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncryptedPassword(), grantList);

        return userDetails;
    }

}
