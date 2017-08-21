package com.example.demo.jwt;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                "user.getFirstname()",
                "user.getLastname()",
                "user.getEmail()",
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                true,
                null
//                user.getEnabled(),
//                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }
}
