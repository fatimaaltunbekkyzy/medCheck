package daoImpl;

import dao.DoctorDao;
import dao.GenericDao;
import daoImpl.database.Database;
import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;

import java.util.ArrayList;
import java.util.List;

import static daoImpl.database.Database.*;
import static daoImpl.database.GeneratorId.hospitalId;

public class DoctorDaoImpl implements DoctorDao, GenericDao<Doctor> {

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        Database.doctors.add(doctor);
        return "Hospital added success fully";
    }

    @Override
    public void removeById(Long id) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId().equals(id)) {
              departments.remove(i);
                System.out.println("doctor ийгилуктуу очурулду: " + id);
                return;
            }
        }
        System.out.println("doctor табылган жок");
    }

    public String updateById(Long id, Doctor doctor) {
        for (Doctor oldDoctor : doctors) {
            if (doctor.getId().equals(id)) {
                oldDoctor.setFirstName(doctor.getFirstName());
                oldDoctor.setLastName(doctor.getLastName());
                oldDoctor.setLastName(doctor.getLastName());
            }
        }
        return "Пациент с ID " + id + " успешно обновлен.";
    }
    @Override
    public Doctor findDoctorById(Long id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Department department : Database.departments) {
            if (department.getId().equals(departmentId)) {
                for (Long doctorId : doctorsId) {
                    for (Doctor doctor : Database.doctors) {
                        if (doctor.getId().equals(doctorId)) {
                            department.getDoctors().add(doctor);
                        }
                    }
                }
                return "Доктора успешно назначены в отделение.";
            }
        }
        return "Отделение не найдено.";  // Если отделение не найдено
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDoctors();
            }
        }
        System.out.println("Больница с ID " + id + " не найдена.");
        return new ArrayList<>();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Department department : Database.departments) {
            if (department.getId().equals(id)) {
                return department.getDoctors();
            }
        }
        System.out.println("Отделение с ID " + id + " не найдено.");
        return new ArrayList<>();
    }
}
