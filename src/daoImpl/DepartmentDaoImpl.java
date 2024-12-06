package daoImpl;

import dao.DepartmentDao;
import dao.GenericDao;
import daoImpl.database.Database;
import models.Department;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

import static daoImpl.database.Database.departments;
import static daoImpl.database.Database.hospitals;
import static daoImpl.database.GeneratorId.hospitalId;


public class DepartmentDaoImpl implements DepartmentDao, GenericDao<Department> {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        Hospital hospital = new HospitalDaoImpl().findHospitalById(id);
        if (hospital != null) {
            return hospital.getDepartments();
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Department department : departments) {
            if (department.getDepartmentName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        Hospital hospital = new HospitalDaoImpl().findHospitalById(hospitalId);
        if (hospital != null) {
            hospital.getDepartments().add(department);
            return "Successfully added";
        }
        return "Try again";
    }

    @Override
    public void removeById(Long id) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getId().equals(id)) {
                departments.remove(i);
                System.out.println("Оорукана ийгилуктуу очурулду: " + id);
                return;
            }
        }
        System.out.println("Оорукана табылган жок");
    }

    @Override
    public String updateById(Long id, Department department) {
        for (Department department1 : departments) {
            if (department1.getId().equals(id)) {
                department1.setDepartmentName(department.getDepartmentName());
                return "Successfully updated";
                }

        }
        return "кайрадан аракет кылыныз";
    }}