package com.example.demo.config.social.impl;

import com.example.demo.api.repository.UserRepository;
import com.example.demo.config.SecurityUser;
import com.example.demo.config.social.CustomSocialAndUserDetailService;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * Created by whilemouse on 17. 8. 22.
 */
@Slf4j
@Service
public class CustomSocialAndUserDetailServiceImpl implements CustomSocialAndUserDetailService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("사용자가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getAuthorities().forEach(authority ->
                authorities.add(new SimpleGrantedAuthority(authority.getName()))
        );

        return new SecurityUser(
                user.getUsername(),
                user.getPassword(),
//                user.isEnabled(),
//                user.isEnabled(),
//                user.isEnabled(),
//                user.isEnabled(),
                true,true,true,true,
                authorities,
                user
        );
    }

    @Override
    public UserDetails loadUserById(long id) throws UsernameNotFoundException {
        User user = userRepository.findOne(id);
        return loadUserByUsername(user.getUsername());
    }

//    @Override
//    public User loadUserByConnectionKey(ConnectionKey connectionKey) {
//        User user = userDAO.findByUserSocial_ProviderIdAndUserSocial_ProviderUserId(SocialProvider.valueOf(connectionKey.getProviderId()), connectionKey.getProviderUserId());
//        return checkUser(user);
//    }

//    @Override
//    public void updateUserSocial(User user) {
//        userDAO.saveAndFlush(user);
//    }

//    @Override
//    public SocialUserDetails loadUserByUserId(String uniqueId) throws UsernameNotFoundException {
//        log.debug("SOCIAL USER ID : {}", uniqueId);
//        return loadUserByUsername(uniqueId);
//    }

    private User checkUser(User user){
        if(user == null)
            throw new UsernameNotFoundException("");
        return user;
    }

}
