package server;

import dao.PatientDao;

import java.util.List;
import java.util.Map;

public interface PatientService {
    String addPatientsToHospital(Long id, List<PatientDao> patients);

    PatientDao getPatientById(Long id);

    Map<Integer, PatientDao> getPatientByAge();

    List<PatientDao> sortPatientsByAge(String ascOrDesc);
}
