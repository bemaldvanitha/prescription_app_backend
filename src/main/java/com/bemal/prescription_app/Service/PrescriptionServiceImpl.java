package com.bemal.prescription_app.Service;

import com.bemal.prescription_app.Dto.PrescriptionResponse;
import com.bemal.prescription_app.Dto.SingleDrugResponse;
import com.bemal.prescription_app.Dto.SinglePrescriptionResponse;
import com.bemal.prescription_app.Entity.Prescription;
import com.bemal.prescription_app.Entity.QPrescription;
import com.bemal.prescription_app.Entity.User;
import com.bemal.prescription_app.Repository.PrescriptionRepository;
import com.bemal.prescription_app.Repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    private final UserRepository userRepository;
    private final PrescriptionRepository prescriptionRepository;

    private final JPAQueryFactory queryFactory;

    public PrescriptionServiceImpl(EntityManager entityManager, UserRepository userRepository, PrescriptionRepository prescriptionRepository) {
        this.queryFactory = new JPAQueryFactory(entityManager);
        this.userRepository = userRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public List<PrescriptionResponse> getAllPrescriptions(Long userId) {
        List<PrescriptionResponse> prescriptionList = new ArrayList<PrescriptionResponse>();
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            QPrescription prescription = QPrescription.prescription;
            List<Prescription> prescriptions = queryFactory.selectFrom(prescription).where(prescription.user.id.eq(userId)).fetch();

            prescriptions.forEach(prescriptionItem -> {
                PrescriptionResponse prescriptionResponse = new PrescriptionResponse(prescriptionItem.getId(), prescriptionItem.getCreatedAt(),
                        prescriptionItem.getPatientName(), prescriptionItem.getMobileNumber(), prescriptionItem.getAge());
                prescriptionList.add(prescriptionResponse);
            });
        }
        return prescriptionList;
    }

    @Override
    public List<PrescriptionResponse> searchPrescription(Long userId, String searchString) {
        List<PrescriptionResponse> prescriptionList = new ArrayList<PrescriptionResponse>();
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            QPrescription prescription = QPrescription.prescription;
            List<Prescription> prescriptions = queryFactory.selectFrom(prescription).where(prescription.patientName.contains(searchString)
                    .or(prescription.mobileNumber.contains(searchString))).fetch();

            prescriptions.forEach(prescriptionItem -> {
                PrescriptionResponse prescriptionResponse = new PrescriptionResponse(prescriptionItem.getId(), prescriptionItem.getCreatedAt(),
                        prescriptionItem.getPatientName(), prescriptionItem.getMobileNumber(), prescriptionItem.getAge());
                prescriptionList.add(prescriptionResponse);
            });
        }
        return prescriptionList;
    }

    @Override
    public List<PrescriptionResponse> filterPrescription(Long userId, Date createdAt) {
        List<PrescriptionResponse> prescriptionList = new ArrayList<PrescriptionResponse>();
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            QPrescription prescription = QPrescription.prescription;
            List<Prescription> prescriptions = queryFactory.selectFrom(prescription).where(prescription.createdAt.eq(createdAt)).fetch();

            prescriptions.forEach(prescriptionItem -> {
                PrescriptionResponse prescriptionResponse = new PrescriptionResponse(prescriptionItem.getId(), prescriptionItem.getCreatedAt(),
                        prescriptionItem.getPatientName(), prescriptionItem.getMobileNumber(), prescriptionItem.getAge());
                prescriptionList.add(prescriptionResponse);
            });
        }
        return prescriptionList;
    }

    @Override
    public SinglePrescriptionResponse getSinglePrescription(Long prescriptionId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId).orElse(null);
        if(prescription == null){
            return null;
        }

        List<SingleDrugResponse> drugResponses = new ArrayList<>();
        prescription.getDrugs().forEach(drugItem -> {
            SingleDrugResponse singleDrugResponse = new SingleDrugResponse(drugItem.getId(), drugItem.getDrugName(),
                    drugItem.getStrength(), drugItem.getDrugStrengthUnit().getUnit(), drugItem.getDose(),
                    drugItem.getDoseUnit().getUnit(), drugItem.getPreparation().getPreparation(), drugItem.getRoute().getRoute(),
                    drugItem.getDirection().getDirection(), drugItem.getFrequency().getFrequency(), drugItem.getDuration(),
                    drugItem.getDurationUnit().getUnit(), drugItem.getTotalQuantity(), drugItem.getOtherInstructions());
            drugResponses.add(singleDrugResponse);
        });

        return new SinglePrescriptionResponse(prescription.getId(), prescription.getCreatedAt(),
                prescription.getPatientName(), prescription.getDateOfBirth(), prescription.getAge(), prescription.getGender().getGender(),
                prescription.getMobileNumber(), prescription.getAddress(), prescription.getHeight(), prescription.getHeightUnit().getUnit(),
                prescription.getWeight(), prescription.getWeightUnit().getUnit(), prescription.getDiagnosis(),
                prescription.getPatientComplains(), prescription.getClinicalFeatures(),prescription.getExamination(),
                prescription.getAdvice(), prescription.getNotes(), prescription.getIsNoteIncluded(), drugResponses);
    }
}
