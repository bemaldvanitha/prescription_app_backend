package com.bemal.prescription_app.Service;

import com.bemal.prescription_app.Dto.PrescriptionResponse;

import java.util.List;

public interface PrescriptionService {
    List<PrescriptionResponse> getAllPrescriptions(Long userId);

    List<PrescriptionResponse> searchPrescription(Long userId, String searchString);

    void filterPrescription();
}
