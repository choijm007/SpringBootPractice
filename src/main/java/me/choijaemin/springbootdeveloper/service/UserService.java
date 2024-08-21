package me.choijaemin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.choijaemin.springbootdeveloper.domain.User;
import me.choijaemin.springbootdeveloper.dto.AddUserRequest;
import me.choijaemin.springbootdeveloper.repository.UserRepsoitory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepsoitory userRepsoitory;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepsoitory.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword())).build())
                .getId();
    }
}
