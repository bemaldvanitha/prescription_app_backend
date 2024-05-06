package com.bemal.prescription_app.Service;

import com.bemal.prescription_app.Dto.PrescriptionAnalyticResponse;
import com.bemal.prescription_app.Dto.PrescriptionResponse;
import com.bemal.prescription_app.Dto.SinglePrescriptionRequest;
import com.bemal.prescription_app.Dto.SinglePrescriptionResponse;

import java.util.Date;
import java.util.List;

public interface PrescriptionService {
    List<PrescriptionResponse> getAllPrescriptions(Long userId);

    List<PrescriptionResponse> searchPrescription(Long userId, String searchString);

    List<PrescriptionResponse> filterPrescription(Long userId, Date createdAt);

    List<PrescriptionResponse> getPrescriptionBuPatient(Long userId, String patientName);

    SinglePrescriptionResponse getSinglePrescription(Long prescriptionId);

    void addPrescription(SinglePrescriptionRequest singlePrescriptionRequest, Long userId);

    List<PrescriptionAnalyticResponse> prescriptionAnalysis(Date startingDate, Date endingDate, Long userId);
}
