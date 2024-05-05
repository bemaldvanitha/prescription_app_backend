package com.bemal.prescription_app.Service;

import com.bemal.prescription_app.Dto.*;

public interface AuthenticationService {
    SignupResponse signup(SignupRequest signupRequest);

    LoginResponse login(LoginRequest loginRequest);

    RegistrationResponse registration(RegisterRequest registerRequest, Long userId);

    UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest, Long userId);
}
