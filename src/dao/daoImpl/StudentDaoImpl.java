package dao.daoImpl;

import dao.StudentDao;
import database.Database;
import enums.Gender;
import models.Group;
import models.Lesson;
import models.Student;

import java.util.*;

public class StudentDaoImpl implements StudentDao {

    Database database = new Database();


     public String addStudentToGroup(String groupName, Student student) {
        try {
            if (!student.getEmail().contains("@")) {
                throw new IllegalArgumentException("Email '@' символун камтуусу керек.");
            }
            for (Student existingStudent : Database.students) {
                if (existingStudent.getEmail().equals(student.getEmail())) {
                    throw new IllegalArgumentException("Email окшош болбошу керек.");
                }
            }
            if (student.getPassword().length() < 7) {
                throw new IllegalArgumentException("Пароль 7 символдон аз болбосун.");
            }

            if (student.getGender() == null ||
                    (!student.getGender().toString().equalsIgnoreCase("male") &&
                            !student.getGender().toString().equalsIgnoreCase("female"))) {
                throw new IllegalArgumentException("Gender 'male' же 'female' болушу керек.");
            }
            for (Group group : Database.groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    if (group.getStudents() == null) {
                        group.setStudents(new HashSet<>());
                    }
                    group.getStudents().add(student);
                    Database.students.add(student);
                    return  group.getGroupName() + " аттуу группага жаны студент ийгиликтуу кошулду : ";
                }
            }
            throw new IllegalArgumentException("Мындай группа табылган жок");

        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }


    @Override
    public Student updateStudent(String email, Student updatedStudent) {
        try {

            if (updatedStudent.getPassword() == null || updatedStudent.getPassword().length() < 7) {
                throw new IllegalArgumentException("Пароль 7 символдон аз болбосун.");
            }

            if (updatedStudent.getGender() == null ||
                    (updatedStudent.getGender() != Gender.MALE && updatedStudent.getGender() != Gender.FEMALE)) {
                throw new IllegalArgumentException("Gender 'male' же 'female' болушу керек.");
            }
            for (Student student : Database.students) {
                if (student.getEmail().equals(email)) {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setPassword(updatedStudent.getPassword());
                    student.setGender(updatedStudent.getGender());
                    return student;
                }
            }
            throw new IllegalArgumentException("Мындай почтасы менен студент жок.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }


    @Override
public Student findByFirstName(String name) {
    try {
        for (Student student : Database.students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Мындай " + name + " аттуу студент табылган жок.");
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
        return null;
    }
}



    @Override
    public Set<Student> getAllStudentsByGroupName(String groupName) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                if (group.getStudents() != null) {
                    return group.getStudents();
                }
                return new HashSet<>();
            }
        }
        throw new IllegalArgumentException("Мындай " + groupName + " аттуу группа табылган жок.");
    }



@Override
public Set<Lesson> getStudentLessons(String email) {
    try {
        for (Group group : Database.groups) {
            if (group.getStudents() != null) {
                for (Student student : group.getStudents()) {
                    if (student.getEmail().equalsIgnoreCase(email)) {
                        return group.getLessons();
                    }
                }
            }
        }
        throw new IllegalArgumentException("Мындай " + email + "  менен студент табылган жок.");

    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Кутуусуз ката: " + e.getMessage());
    }

    return Set.of();
}




    @Override
    public String deleteStudent(String name) {

        boolean removed = false;

        for (Group group : Database.groups) {
            Set<Student> students = group.getStudents();
            if (students != null) {
                for (Student student : new HashSet<>(students)) {
                    if (student.getFirstName().equals(name)) {
                        students.remove(student);
                        removed = true;
                    }
                }
            }
        }
        for (Student student : new HashSet<>(Database.students)) {
            if (student.getFirstName().equals(name)) {
                Database.students.remove(student);
                removed = true;
            }
        }

        if (!removed) {
            throw new RuntimeException("Мындай  " + name + " студент табылган жок.");
        }

        return  name + " аттуу студент очурулду .";
    }


}
