package com.meryem.service;

import com.meryem.dto.request.RegisterRequestDto;
import com.meryem.entity.Auth;
import com.meryem.repository.AuthRepository;
import com.meryem.utility.enums.ERole;
import com.meryem.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    public boolean register(RegisterRequestDto dto){
        Auth auth = Auth.builder()
                .username(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(ERole.USER)
                .status(EStatus.PENDING)
                .build();
        authRepository.save(auth);
        return true;
    }
}
