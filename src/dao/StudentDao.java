package dao;

import models.Group;
import models.Lesson;
import models.Student;

import java.util.List;
import java.util.Set;

public interface StudentDao {

    String addStudentToGroup(String groupName, Student student);

    Student updateStudent(String email, Student student);

    Student findByFirstName(String name);

    Set<Student> getAllStudentsByGroupName(String groupName);

     Set<Lesson> getStudentLessons(String email);

    String deleteStudent(String name);





}
