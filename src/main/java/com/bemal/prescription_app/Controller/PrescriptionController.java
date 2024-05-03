package com.bemal.prescription_app.Controller;

import com.bemal.prescription_app.Dto.PrescriptionResponse;
import com.bemal.prescription_app.Helper.JwtTokenProvider;
import com.bemal.prescription_app.Service.PrescriptionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController("/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PrescriptionResponse>> getPrescriptionsAssignedByUser(@RequestHeader(name="Authorization") String token){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }

        return ResponseEntity.status(200).body(prescriptionService.getAllPrescriptions(tokenValidationResult.getUserId()));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PrescriptionResponse>> getPrescriptionBySearchString(@RequestParam(name = "searchTerm") String searchTerm, @RequestHeader(name="Authorization") String token){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.status(200).body(prescriptionService.searchPrescription(tokenValidationResult.getUserId(), searchTerm));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PrescriptionResponse>> getPrescriptionBySortDate(@RequestParam(name = "createdAt") @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdAt,
                                                                                @RequestHeader(name = "Authorization") String token){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }

        return ResponseEntity.status(200).body(prescriptionService.filterPrescription(tokenValidationResult.getUserId(), createdAt));
    }
}
