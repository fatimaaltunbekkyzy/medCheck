package server;

import models.Hospital;
import models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalService {

    String addHospital(Hospital hospital);

    List<Hospital> getAllHospital();

    Hospital findHospitalById(Long id);

    List<Patient> getAllPatientFromHospital(Long id);

    String deleteHospitalById(Long id);

    Map<String, Hospital> getAllHospitalByAddress(String address);
}
