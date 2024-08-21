package me.choijaemin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.choijaemin.springbootdeveloper.domain.User;
import me.choijaemin.springbootdeveloper.repository.UserRepsoitory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepsoitory userRepsoitory;

    @Override
    public User loadUserByUsername(String email){
        return userRepsoitory.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }

}
