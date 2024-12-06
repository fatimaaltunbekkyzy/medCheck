package dao;

import java.util.List;
import java.util.Map;

public interface PatientDao {

    String addPatientsToHospital(Long id, List<PatientDao> patients);

    PatientDao getPatientById(Long id);

    Map<Integer, PatientDao> getPatientByAge();

    List<PatientDao> sortPatientsByAge(String ascOrDesc);
}
