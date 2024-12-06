package daoImpl;

import dao.GenericDao;
import dao.PatientDao;
import daoImpl.database.Database;
import models.Hospital;
import models.Patient;
import server.GenericService;

import java.util.*;

import static daoImpl.database.Database.departments;
import static daoImpl.database.Database.patients;

public class PatientDaoImpl implements PatientDao , GenericService<Patient> {

    @Override
    public String addPatientsToHospital(Long id, List<PatientDao> patients) {
        for (Patient patient : Database.patients) {
            if (patient.getId().equals(id)) {
                return "Пациенты успешно добавлены в больницу.";
            }
        }
        return "Больница с таким ID не найдена.";
    }

    @Override
    public PatientDao getPatientById(Long id) {
return  null;
    }

    @Override
    public Map<Integer, PatientDao> getPatientByAge() {
//        Map<Integer,Patient> patientMap = new HashMap<>();
//        for (Hospital hospital:Database.hospitals){
//            for (Patient patient:hospital.getPatients()){
//                patientMap.put(patient.getAge(),patient);
//            }
//        }return patientMap;
        return  null;

    }

    @Override
    public List<PatientDao> sortPatientsByAge(String ascOrDesc) {
        Comparator<Patient> patientComparator = Comparator.comparing(Patient::getAge);
        if ("desc".equalsIgnoreCase(ascOrDesc)) {
            patientComparator = patientComparator.reversed();
        }
//        Database.patients.sort(patientComparator);
//        return new ArrayList<>(Database.patients);
        return  null;

    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Patient patient1 : Database.patients) {
            if (patient1.getId().equals(hospitalId)) {
                return " Бул оорукана бар.";
            }
        }
        Database.patients.add(patient);
        return "Оорукана ийгиликтүү кошулду";

    }

    @Override
    public void removeById(Long id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
               patients.remove(i);
                System.out.println("patient ийгилуктуу очурулду: " + id);
                return;
            }
        }
        System.out.println("patient табылган жок");
    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (Patient oldPatient : Database.patients) {
            if (oldPatient.getId().equals(id)) {
                oldPatient.setFirstName(patient.getFirstName());
                oldPatient.setLastName(patient.getLastName());
                oldPatient.setAge(patient.getAge());
                oldPatient.setGender(patient.getGender());
                return "Пациент с ID " + id + " успешно обновлен.";
            }
        }
        return "Пациент с таким ID не найден.";
    }}