package com.bemal.prescription_app.Controller;

import com.bemal.prescription_app.Dto.*;
import com.bemal.prescription_app.Helper.JwtTokenProvider;
import com.bemal.prescription_app.Service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest signupRequest) {
        SignupResponse signupResponse = authenticationService.signup(signupRequest);
        return ResponseEntity.status(signupResponse.getStatusCode()).body(signupResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authenticationService.login(loginRequest);
        return ResponseEntity.status(loginResponse.getStatusCode()).body(loginResponse);
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