package com.bemal.prescription_app.Service;

import com.bemal.prescription_app.Dto.*;
import com.bemal.prescription_app.Entity.QUser;
import com.bemal.prescription_app.Entity.User;
import com.bemal.prescription_app.Helper.JwtTokenProvider;
import com.bemal.prescription_app.Helper.MD5PasswordEncoder;
import com.bemal.prescription_app.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SignupResponse signup(SignupRequest signupRequest) {
        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setPassword(MD5PasswordEncoder.encrypt(signupRequest.getPassword()));

        User savedUser = userRepository.save(user);
        String jwtToken = JwtTokenProvider.generateToken(user.getPhoneNumber(), savedUser.getId());

        return new SignupResponse(jwtToken, "User Sign up successful", 201);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findOne(QUser.user.phoneNumber.eq(loginRequest.getMobileNumber())).orElse(null);

        if(user == null){
            return new LoginResponse(null,"Authentication error", 404);
        }

        String encodedPassword = MD5PasswordEncoder.encrypt(loginRequest.getPassword());

        if(!encodedPassword.equals(user.getPassword())){
            return new LoginResponse(null,"Authentication error", 404);
        }else {
            String jwtToken = JwtTokenProvider.generateToken(user.getPhoneNumber(), user.getId());
            return new LoginResponse(jwtToken,"User Login successful", 200);
        }
    }

    @Override
    public RegistrationResponse registration(RegisterRequest registerRequest, Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null){
            return new RegistrationResponse("Registration Failed, User not found", 404);
        }

        user.setName(registerRequest.getName());
        user.setAddress(registerRequest.getAddress());
        user.setInstituteName(registerRequest.getInstituteName());
        user.setQualification(registerRequest.getQualification());
        user.setRegistrationNumber(registerRequest.getRegistrationNumber());
        user.setOtherDetails(registerRequest.getOtherDetails());

        userRepository.save(user);

        return new RegistrationResponse("Registration successful", 200);
    }

    @Override
    public UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest, Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null){
            return new UpdateProfileResponse("Update Profile Failed", 404);
        }

        User isPhoneNumberUsedBefore = userRepository.findOne(QUser.user.phoneNumber.eq(updateProfileRequest.getPhoneNumber()))
                .orElse(null);

        User isEmailUsedBefore = userRepository.findOne(QUser.user.email.eq(updateProfileRequest.getEmail())).orElse(null);

        if(isEmailUsedBefore != null && isEmailUsedBefore.getId().equals(user.getId())){
            return new UpdateProfileResponse("That Email is already taken", 404);
        }

        if(isPhoneNumberUsedBefore != null && isPhoneNumberUsedBefore.getId().equals(user.getId())){
            return new UpdateProfileResponse("That Mobile number is already taken", 404);
        }

        user.setEmail(updateProfileRequest.getEmail());
        user.setPhoneNumber(updateProfileRequest.getPhoneNumber());
        user.setQualification(updateProfileRequest.getQualifications());
        user.setAddress(updateProfileRequest.getAddress());
        user.setInstituteName(updateProfileRequest.getInstituteName());
        user.setOtherDetails(updateProfileRequest.getOtherDetails());
        userRepository.save(user);

        return new UpdateProfileResponse("User updated successfully", 200);
    }
}
