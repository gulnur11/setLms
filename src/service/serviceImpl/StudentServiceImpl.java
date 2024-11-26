package service.serviceImpl;

import dao.StudentDao;
import dao.daoImpl.StudentDaoImpl;
import models.Lesson;
import models.Student;
import service.StudentService;

import java.util.List;
import java.util.Set;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();


    @Override
    public String addStudentToGroup(String groupName, Student student) {
        return studentDao.addStudentToGroup(groupName,student);
    }

    @Override
    public Student updateStudent(String email, Student student) {
        return studentDao.updateStudent(email, student);
    }


    @Override
    public Student findByFirstName(String name) {
        return studentDao.findByFirstName(name);
    }

    @Override
    public Set<Student> getAllStudentsByGroupName(String groupName) {
        return studentDao.getAllStudentsByGroupName(groupName);
    }

    @Override
    public Set<Lesson> getStudentLessons(String email) {
        return studentDao.getStudentLessons(email);
    }

    @Override
    public String deleteStudent(String name) {
        return studentDao.deleteStudent(name);
    }


}
