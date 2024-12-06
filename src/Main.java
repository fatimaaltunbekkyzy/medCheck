import dao.GenericDao;
import daoImpl.database.Database;
import daoImpl.database.GeneratorId;
import enams.Gender;
import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;
import server.*;
import serviceImpl.DepartmentImpl;
import serviceImpl.DoctorImpl;
import serviceImpl.HospitalImpl;
import serviceImpl.PatientImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       Scanner scanner1 = new Scanner(System.in);

        HospitalService hospitalService =new HospitalImpl();
        hospitalService.addHospital(new Hospital(GeneratorId.hospitalId(), "Бишкек Ооруканасы", "Бишкек, Кыргызстан",Database.departments,Database.doctors,Database.patients));
        hospitalService.addHospital(new Hospital(GeneratorId.hospitalId(), "Ош Ооруканасы", "Ош, Кыргызстан",Database.departments,Database.doctors,Database.patients));

        GenericService genericService = new DepartmentImpl();
        DepartmentService departmentService = new DepartmentImpl();
        // Бөлүмдөрдү түзүү жана докторлорду кошуу
        Department department1 = new Department(GeneratorId.departmentId(), "Хирургия");
        Department department2 = new Department(GeneratorId.departmentId(), "Терапия");
      //  System.out.println(genericService.add(1L,new Department(GeneratorId.departmentId(),"newDepartment")));
        System.out.println(department1);
        System.out.println(department2);

        DoctorService doctorService = new DoctorImpl();
        Doctor doctor1 = new Doctor(GeneratorId.doctorId(), "Айбек", "Жанбеков", Gender.MALE, 10);
        Doctor doctor2 = new Doctor(GeneratorId.doctorId(), "Светлана", "Садыкова", Gender.FEMALE, 5);
        System.out.println(doctor1);
        System.out.println(doctor2);

        PatientService patientService = new PatientImpl();
        // Пациенттерди түзүү
        Patient patient1 = new Patient(GeneratorId.patientId(), "Анарa", "Тургунова", 25, Gender.FEMALE);
        Patient patient2 = new Patient(GeneratorId.patientId(), "Эмил", "Токторов", 30, Gender.MALE);
        System.out.println(patient1);
        System.out.println(patient2);

      //   Бөлүмдөрдү түзүү жана докторлорду кошуу
       Database.departments.add( new Department(GeneratorId.departmentId(), "Хирургия"));
       Database.departments.add(new Department(GeneratorId.departmentId(), "Терапия"));

        while (true) {
            System.out.println("\nТөмөнкү аракеттердин бирин тандаңыз:");
            System.out.println("1 - Бардык ооруканаларды алуу");
            System.out.println("2 - Оорукана ID боюнча издөө");
            System.out.println("3 - Оорукана дареги боюнча издөө");
            System.out.println("4 - Пациенттерди көрүү");
            System.out.println("5 - Оорукана жок кылуу");
            System.out.println("6 - Бардык болумдорду алуу");
            System.out.println("7 - болумду аты менен издоо");
            System.out.println("8 - болумду жаныртуу");
            System.out.println("9 - болумду очуруп салуу");
            System.out.println("10 -findDoctorById ");
            System.out.println("11 -assignDoctorToDepartment");
            System.out.println("12 -getAllDoctorsByHospitalId");
            System.out.println("13 -getAllDoctorsByDepartmentId");
            System.out.println("14 - add");
            System.out.println(" 15 .removeById");
            System.out.println("16 - Чыгуу");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Бардык ооруканаларды көрсөтүү
                    System.out.println("Бардык оорукандар:");
                    System.out.println(hospitalService.getAllHospital());
                    break;
                case 2:
                    // Оорукана ID боюнча издөө
                    System.out.print("ID боюнча оорукана издөө үчүн ID жазыңыз: ");
                    Long hospitalId = scanner.nextLong();
                    System.out.println(hospitalService.findHospitalById(hospitalId));
                    break;

                case 3:
                    // Оорукана дареги боюнча издөө
                    System.out.print("Дареги боюнча оорукана издөө үчүн дарегин жазыңыз: ");
                    //  scanner.nextLine();  // Consume newline left by nextLong
                    String address = scanner.nextLine();
                    System.out.println(hospitalService.getAllHospitalByAddress(address));
                    break;
                case 4:
                    // Пациенттерди көрүү
                    System.out.print("Пациенттерди көрүү үчүн оорукана ID жазыңыз: ");
                    hospitalId = scanner.nextLong();
                    System.out.println(hospitalService.getAllPatientFromHospital(hospitalId));
                    break;

                case 5:
                    // Оорукана жок кылуу
                    System.out.print("Жок кылуу үчүн оорукана ID жазыңыз: ");
                    hospitalId = scanner.nextLong();
                    System.out.println(hospitalService.deleteHospitalById(hospitalId));
                    break;
                case 6:
                    System.out.println(" баарык болумдорду алуу");
                    System.out.println(departmentService.getAllDepartmentByHospital(1L));
                    break;
                case 7:
                    System.out.println(" болумду аты менен издоо");
                    String DepartmentName=scanner.nextLine();
                    departmentService.findDepartmentByName(DepartmentName);
                    break;
                case 8:
                    System.out.println("болумду жаныртуу  id син жазыныз");
                    Long departmentId=scanner.nextLong();
                    System.out.println("болумду жаныртуу атын жазыныз");
                    String dName=scanner1.nextLine();
                    genericService.updateById(departmentId,dName);
                    break;
                case 9:
                    System.out.println("болумунду очуруу учун id син жазыныз");
                    Long DepartmentId=scanner.nextLong();
                    genericService.removeById(DepartmentId);
                    break;
                case 10:
                    System.out.print("ID боюнча оорукана издөө үчүн ID жазыңыз: ");
                    Long doctorId2 = scanner.nextLong();
                    System.out.println(doctorService.findDoctorById(doctorId2));
                    break;
                case 11:
                    System.out.println("assignDoctorToDepartment");
                    String DoctorName=scanner1.nextLine();
                 //   System.out.println(doctorService.assignDoctorToDepartment(DoctorName));
                case 12:
                    System.out.println("getAllDoctorsByHospitalId");
                    Long doctorId3 = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(doctorId3));
                    break;
                case 13:
                    System.out.println("getAllDoctorsByDepartmentId");
                    Long doctorId4 = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(doctorId4));
                    break;
                case 14:
                    // Бардык ооруканаларды көрсөтүү
                    System.out.println("doctor жаныртуу  id син жазыныз");
                    System.out.println(genericService.add(1L,new Doctor(GeneratorId.doctorId(),"Adilet","Egembtrdiev",Gender.MALE,12)));
                    break;
                case 15:
                    System.out.print("Жок кылуу үчүн doctor ID жазыңыз: ");
                    Long doctorId = scanner.nextLong();
                    genericService.removeById(doctorId);
                    break;

                case 16:
                    // Программаны токтотуу
                    System.out.println("Программа аяктады.");
                    break;
            }}}}