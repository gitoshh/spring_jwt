package com.example.springJwt.auth;

import org.springframework.stereotype.Component;

@Component
public interface AuthenticationService {

    public AuthenticationResponse register(RegisterRequest request);

    public AuthenticationResponse authenticate(AuthenticateRequest request);
}
