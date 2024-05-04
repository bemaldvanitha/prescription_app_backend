package com.bemal.prescription_app.Service;

import com.bemal.prescription_app.Dto.PrescriptionResponse;
import com.bemal.prescription_app.Dto.SinglePrescriptionResponse;

import java.util.Date;
import java.util.List;

public interface PrescriptionService {
    List<PrescriptionResponse> getAllPrescriptions(Long userId);

    List<PrescriptionResponse> searchPrescription(Long userId, String searchString);

    List<PrescriptionResponse> filterPrescription(Long userId, Date createdAt);

    SinglePrescriptionResponse getSinglePrescription(Long prescriptionId);
}
