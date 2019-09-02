package com.store.app.service;

import com.store.app.entity.AppRole;
import com.store.app.entity.AppUser;
import com.store.app.entity.UserRole;
import com.store.app.repository.AppRoleRepository;
import com.store.app.repository.AppRoleRepository;
import com.store.app.repository.UserRepository;
import com.store.app.repository.UserRoleRepository;
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
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUserName(userName);
        System.out.println("Found User: " + appUser);

        List<UserRole> rolesList = userRoleRepository.findRoleIdByUserId(appUser.getUserId());

        AppRole roleNames = appRoleRepository.findRoleNameByRoleId(rolesList.stream()
                .filter(bean -> bean.getUserId() == appUser.getUserId())
                .findFirst()
                .get()
                .getUserRole());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        grantList.add(new SimpleGrantedAuthority(roleNames.getRoleName()));
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncryptedPassword(), grantList);

        return userDetails;
    }

}
