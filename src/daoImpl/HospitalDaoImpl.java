package daoImpl;

import dao.GenericDao;
import dao.HospitalDao;
import daoImpl.database.Database;
import models.Hospital;
import models.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static daoImpl.database.GeneratorId.hospitalId;


public class HospitalDaoImpl implements HospitalDao, GenericDao<Hospital> {
   // private final List<Hospital> hospitals = new ArrayList<>();

    @Override
    public String addHospital(Hospital hospital) {
     Database.hospitals.add(hospital);
        return "Hospital added success fully";
    }
    @Override
    public List<Hospital> getAllHospital() {
     return Database.hospitals;
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId()==(id)) {
                System.out.println("Оорукана табылды: " + hospital.getHospitalName());
                return hospital;
            }
        }
        System.out.println("Оорукана табылган жок.");
        return null;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getPatients();
            }
        }
        return null;
        }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital hospital: Database.hospitals){
            if (hospital.getId().equals(id)){
                Database.hospitals.remove(hospital);
                return "Deleted success fully";
            }
        }
        return "hospital not found";

    }
    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> result = new HashMap<>();
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getAddress().equalsIgnoreCase(address)) {
                result.put(hospital.getHospitalName(), hospital);
            }
        }
        return result;
    }

    @Override
    public String add(Long hospitalId, Hospital hospital) {
        for (Hospital hospital1 : Database.hospitals) {
            if (hospital1.getId().equals(hospitalId)) {
                return " Бул оорукана бар.";
            }
        }
        Database.hospitals.add(hospital);
        return "Оорукана ийгиликтүү кошулду";

    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                Database.hospitals.remove(hospital);
                System.out.println("Оорукана ийгилуктуу очурулду"+id);
            }
        }
        System.out.println("Оорукана табылган жок");
    }
    @Override
    public String updateById(Long id, Hospital hospital) {
        for (Hospital oldHospital : Database.hospitals) {
            if (oldHospital.getId().equals(hospitalId)) {
                oldHospital.setHospitalName(hospital.getHospitalName());
                oldHospital.setAddress(hospital.getAddress());
                System.out.println("Жаң кошулган оорукана: " + oldHospital);
                return "Оорукана ийгиликтүү кошулду.";
            }
        }
            return "Оорукана табылган жок.";

    }}