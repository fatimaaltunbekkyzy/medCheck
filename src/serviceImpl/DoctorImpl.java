package serviceImpl;

import dao.DoctorDao;
import dao.GenericDao;
import daoImpl.database.Database;
import models.Department;
import models.Doctor;
import models.Hospital;
import server.DoctorService;

import java.util.ArrayList;
import java.util.List;

public class DoctorImpl implements DoctorService, GenericDao<Doctor> {
    @Override
    public Doctor findDoctorById(Long id) {
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital: Database.hospitals){
            for (Department department:hospital.getDepartments()){
                if (department.getId().equals(departmentId)){
                    List<Doctor> doctors = new ArrayList<>();
                    for (Long doctorId:doctorsId){
                        Doctor doctor = findDoctorById(doctorId);
                        if (doctor!=null){
                            doctors.add(doctor);
                        }
                    }department.getDoctors().addAll(doctors);
                    return "Successfully assigned";
                }
            }
        }return "Try again";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return List.of();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return List.of();
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        return "";
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        return "";
    }
}
