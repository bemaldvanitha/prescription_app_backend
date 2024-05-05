package com.bemal.prescription_app.Controller;

import com.bemal.prescription_app.Dto.*;
import com.bemal.prescription_app.Helper.JwtTokenProvider;
import com.bemal.prescription_app.Service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest signupRequest) {
        return authenticationService.signup(signupRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }

    @PatchMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegisterRequest registerRequest,
                                                         @RequestHeader (name="Authorization") String token){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }

        RegistrationResponse registrationResponse = authenticationService.registration(registerRequest,
                tokenValidationResult.getUserId());

        return ResponseEntity.status(registrationResponse.getStatusCode()).body(registrationResponse);
    }

    @PatchMapping("/update")
    public ResponseEntity<UpdateProfileResponse> updateProfile(@RequestBody UpdateProfileRequest updateProfileRequest,
                                                               @RequestHeader(name="Authorization") String token){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }

        UpdateProfileResponse updateProfileResponse = authenticationService.updateProfile(updateProfileRequest,
                tokenValidationResult.getUserId());

        return ResponseEntity.status(updateProfileResponse.getStatusCode()).body(updateProfileResponse);
    }
}