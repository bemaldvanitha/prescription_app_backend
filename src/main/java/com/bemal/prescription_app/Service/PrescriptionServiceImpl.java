package com.bemal.prescription_app.Service;

import com.bemal.prescription_app.Dto.*;
import com.bemal.prescription_app.Entity.*;
import com.bemal.prescription_app.Repository.*;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    private final UserRepository userRepository;
    private final PrescriptionRepository prescriptionRepository;

    private final GenderRepository genderRepository;

    private final HeightUnitRepository heightUnitRepository;

    private final WeightUnitRepository weightUnitRepository;

    private final DrugStrengthUnitRepository drugStrengthUnitRepository;

    private final DoseUnitRepository doseUnitRepository;

    private final PreparationRepository preparationRepository;

    private final RouteRepository routeRepository;

    private final DirectionRepository directionRepository;

    private final FrequencyRepository frequencyRepository;

    private final DurationUnitRepository durationUnitRepository;

    private final DrugRepository drugRepository;

    private final JPAQueryFactory queryFactory;

    public PrescriptionServiceImpl(EntityManager entityManager, UserRepository userRepository, PrescriptionRepository prescriptionRepository, GenderRepository genderRepository, HeightUnitRepository heightUnitRepository, WeightUnitRepository weightUnitRepository, DrugStrengthUnitRepository drugStrengthUnitRepository, DoseUnitRepository doseUnitRepository, PreparationRepository preparationRepository, RouteRepository routeRepository, DirectionRepository directionRepository, FrequencyRepository frequencyRepository, DurationUnitRepository durationUnitRepository, DrugRepository drugRepository) {
        this.queryFactory = new JPAQueryFactory(entityManager);
        this.userRepository = userRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.genderRepository = genderRepository;
        this.heightUnitRepository = heightUnitRepository;
        this.weightUnitRepository = weightUnitRepository;
        this.drugStrengthUnitRepository = drugStrengthUnitRepository;
        this.doseUnitRepository = doseUnitRepository;
        this.preparationRepository = preparationRepository;
        this.routeRepository = routeRepository;
        this.directionRepository = directionRepository;
        this.frequencyRepository = frequencyRepository;
        this.durationUnitRepository = durationUnitRepository;
        this.drugRepository = drugRepository;
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

    @Override
    public void addPrescription(SinglePrescriptionRequest singlePrescriptionRequest, Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if(user != null){
            Prescription prescription = new Prescription();

            Date dobDate = singlePrescriptionRequest.getDateOfBirth();
            LocalDate dob = dobDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();

            Period period = Period.between(dob, currentDate);
            int age = period.getYears();

            Gender gender = genderRepository.findOne(QGender.gender1.gender.eq(singlePrescriptionRequest.getGender())).orElse(null);

            if(gender == null){
                Gender createdGender = new Gender();
                createdGender.setGender(singlePrescriptionRequest.getGender());
                gender = genderRepository.save(createdGender);
            }

            HeightUnit heightUnit = heightUnitRepository.findOne(QHeightUnit.heightUnit.unit.eq(singlePrescriptionRequest.getHeightUnit())).orElse(null);

            if(heightUnit == null){
                HeightUnit createdHeightUnit = new HeightUnit();
                createdHeightUnit.setUnit(singlePrescriptionRequest.getHeightUnit());
                heightUnit = heightUnitRepository.save(createdHeightUnit);
            }

            WeightUnit weightUnit = weightUnitRepository.findOne(QWeightUnit.weightUnit.unit.eq(singlePrescriptionRequest.getWeightUnit())).orElse(null);

            if(weightUnit == null){
                WeightUnit createdWeightUnit = new WeightUnit();
                createdWeightUnit.setUnit(singlePrescriptionRequest.getWeightUnit());
                weightUnit = weightUnitRepository.save(createdWeightUnit);
            }

            prescription.setAddress(singlePrescriptionRequest.getAddress());
            prescription.setAdvice(singlePrescriptionRequest.getAdvice());
            prescription.setDiagnosis(singlePrescriptionRequest.getDiagnosis());
            prescription.setDateOfBirth(singlePrescriptionRequest.getDateOfBirth());
            prescription.setHeight(singlePrescriptionRequest.getHeight());
            prescription.setWeight(singlePrescriptionRequest.getWeight());
            prescription.setNotes(singlePrescriptionRequest.getNotes());
            prescription.setNoteIncluded(singlePrescriptionRequest.isNoteIncluded());
            prescription.setExamination(singlePrescriptionRequest.getExamination());
            prescription.setPatientComplains(singlePrescriptionRequest.getPatientComplains());
            prescription.setClinicalFeatures(singlePrescriptionRequest.getClinicalFeatures());
            prescription.setUser(user);
            prescription.setCreatedAt(singlePrescriptionRequest.getCreatedAt());
            prescription.setPatientName(singlePrescriptionRequest.getPatientName());
            prescription.setAge(age);
            prescription.setMobileNumber(singlePrescriptionRequest.getMobileNumber());
            prescription.setGender(gender);
            prescription.setHeightUnit(heightUnit);
            prescription.setWeightUnit(weightUnit);

            Prescription createdPrescription = prescriptionRepository.save(prescription);

            singlePrescriptionRequest.getDrugs().forEach(drugItem -> {
                Drug drug = new Drug();

                DrugStrengthUnit drugStrengthUnit = drugStrengthUnitRepository.findOne(QDrugStrengthUnit.drugStrengthUnit.unit.
                        eq(drugItem.getDrugStrengthUnit())).orElse(null);

                if(drugStrengthUnit == null){
                    DrugStrengthUnit createdDrugStrengthUnit = new DrugStrengthUnit();
                    createdDrugStrengthUnit.setUnit(drugItem.getDrugStrengthUnit());
                    drugStrengthUnit = drugStrengthUnitRepository.save(createdDrugStrengthUnit);
                }

                DoseUnit doseUnit = doseUnitRepository.findOne(QDoseUnit.doseUnit.unit.eq(drugItem.getDoseUnit())).orElse(null);

                if(doseUnit == null){
                    DoseUnit createdDoseUnit = new DoseUnit();
                    createdDoseUnit.setUnit(drugItem.getDoseUnit());
                    doseUnit = doseUnitRepository.save(createdDoseUnit);
                }

                Preparation preparation = preparationRepository.findOne(QPreparation.preparation1.preparation
                        .eq(drugItem.getPreparation())).orElse(null);

                if(preparation == null){
                    Preparation createdPreparation = new Preparation();
                    createdPreparation.setPreparation(drugItem.getPreparation());
                    preparation = preparationRepository.save(createdPreparation);
                }

                Route route = routeRepository.findOne(QRoute.route1.route.eq(drugItem.getRoute())).orElse(null);

                if(route == null){
                    Route createdRoute = new Route();
                    createdRoute.setRoute(drugItem.getRoute());
                    route = routeRepository.save(createdRoute);
                }

                Direction direction = directionRepository.findOne(QDirection.direction1.direction.eq(drugItem.getDirection()))
                        .orElse(null);

                if(direction == null){
                    Direction createdDirection = new Direction();
                    createdDirection.setDirection(drugItem.getDirection());
                    direction = directionRepository.save(createdDirection);
                }

                Frequency frequency = frequencyRepository.findOne(QFrequency.frequency1.frequency.eq(drugItem.getFrequency()))
                        .orElse(null);

                if(frequency == null){
                    Frequency createdFrequency = new Frequency();
                    createdFrequency.setFrequency(drugItem.getFrequency());
                    frequency = frequencyRepository.save(createdFrequency);
                }

                DurationUnit durationUnit = durationUnitRepository.findOne(QDurationUnit.durationUnit.unit
                        .eq(drugItem.getDurationUnit())).orElse(null);

                if(durationUnit == null){
                    DurationUnit createdDurationUnit = new DurationUnit();
                    createdDurationUnit.setUnit(drugItem.getDurationUnit());
                    durationUnit = durationUnitRepository.save(createdDurationUnit);
                }

                drug.setPrescription(createdPrescription);
                drug.setDrugName(drugItem.getDrugName());
                drug.setStrength(drugItem.getStrength());
                drug.setDose(drugItem.getDose());
                drug.setDuration(drugItem.getDuration());
                drug.setTotalQuantity(drugItem.getTotalQuantity());
                drug.setOtherInstructions(drugItem.getOtherInstructions());
                drug.setDrugStrengthUnit(drugStrengthUnit);
                drug.setDoseUnit(doseUnit);
                drug.setPreparation(preparation);
                drug.setRoute(route);
                drug.setDirection(direction);
                drug.setFrequency(frequency);
                drug.setDurationUnit(durationUnit);

                drugRepository.save(drug);
            });
        }
    }

    @Override
    public List<PrescriptionAnalyticResponse> prescriptionAnalysis(Date startingDate, Date endingDate, Long userId) {
        List<PrescriptionAnalyticResponse> analyticResponseList = new ArrayList<PrescriptionAnalyticResponse>();
        Random random = new Random();
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            QPrescription prescription = QPrescription.prescription;
            List<Tuple> prescriptionTuples = queryFactory.select(prescription.createdAt, prescription.count()).from(prescription)
                    .where(prescription.createdAt.between(startingDate, endingDate).and(prescription.user.eq(user)))
                    .groupBy(prescription.createdAt).fetch();

            prescriptionTuples.forEach(tuple -> {
                analyticResponseList.add(new PrescriptionAnalyticResponse(random.nextLong(), tuple.get(prescription.count()).intValue(), tuple.get(prescription.createdAt)));
            });
        }
        return analyticResponseList;
    }
}
