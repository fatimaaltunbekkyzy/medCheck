package serviceImpl;

import dao.GenericDao;
import dao.PatientDao;
import models.Patient;
import server.PatientService;

import java.util.List;
import java.util.Map;

public class PatientImpl implements PatientService, GenericDao<Patient> {

    @Override
    public String add(Long hospitalId, Patient patient) {
        return "";
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public String updateById(Long id, Patient patient) {
        return "";
    }

    @Override
    public String addPatientsToHospital(Long id, List<PatientDao> patients) {
        return "";
    }

    @Override
    public PatientDao getPatientById(Long id) {
        return null;
    }

    @Override
    public Map<Integer, PatientDao> getPatientByAge() {
        return Map.of();
    }

    @Override
    public List<PatientDao> sortPatientsByAge(String ascOrDesc) {
        return List.of();
    }
}
