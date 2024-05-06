package com.bemal.prescription_app.Controller;

import com.bemal.prescription_app.Dto.*;
import com.bemal.prescription_app.Helper.JwtTokenProvider;
import com.bemal.prescription_app.Service.PrescriptionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/prescription")
@CrossOrigin(origins = "*")
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

    @GetMapping("/{id}")
    public ResponseEntity<SinglePrescriptionResponse> getSinglePrescription(@RequestHeader(name = "Authorization") String token,
                                                                            @PathVariable Long id){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.status(200).body(prescriptionService.getSinglePrescription(id));
    }

    @PostMapping("/")
    public ResponseEntity<SavePrescriptionResponse> createPrescription(@RequestHeader(name = "Authorization") String token,
                                             @RequestBody SinglePrescriptionRequest prescriptionRequest){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }

        prescriptionService.addPrescription(prescriptionRequest, tokenValidationResult.getUserId());
        return ResponseEntity.status(200).body(new SavePrescriptionResponse("Prescription saved successfully"));
    }

    @GetMapping("/analysis")
    public ResponseEntity<List<PrescriptionAnalyticResponse>> getPrescriptionAnalysis(@RequestHeader(name = "Authorization") String token,
                                                                                      @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                      @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        JwtTokenProvider.TokenValidationResult tokenValidationResult = JwtTokenProvider.validateToken(token);

        if(!tokenValidationResult.isValid()){
            return ResponseEntity.status(401).body(null);
        }

        return ResponseEntity.status(200).body(prescriptionService.prescriptionAnalysis(startDate, endDate,
                tokenValidationResult.getUserId()));
    }
}
