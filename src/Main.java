import dao.GroupDao;
import dao.StudentDao;
import dao.daoImpl.GroupDaoImpl;
import dao.daoImpl.StudentDaoImpl;
import database.Database;
import database.GenerateId;
import enums.Gender;
import models.Group;
import models.Lesson;
import models.Student;
import service.GroupService;
import service.LessonService;
import service.StudentService;
import service.serviceImpl.GroupServiceImpl;
import service.serviceImpl.LessonServiceImpl;
import service.serviceImpl.StudentServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static database.GenerateId.groupId;

public class Main {
    public static void main(String[] args) {

        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        String greetings;

        if (hour >= 5 &&  hour < 12){
            greetings = "Good morning ! ";
        } else if (hour >= 12 && hour < 18) {
            greetings = "Good afternoon ! ";
        } else if (hour >= 18 && hour < 22) {
            greetings = "Good evening! ";
        }else {
            greetings = "Good night! ";
        }

        System.out.print(greetings);
        System.out.println("Саат: " + currentTime.getHour() + ":" + currentTime.getMinute());



       while (true) {
           System.out.println("Катталган болсонуз 1 басыныз, пароль унутуп калып, озгортуу учун 2 басыныз!");
           Scanner scanner = new Scanner(System.in);
           int number = scanner.nextInt();

           if (number == 1) {
               System.out.println("Кируу учун электрондук почтанызды жана паролунузду жазыныз!");


               String registeredEmail = "admin@gmail.com";
               String registeredPassword = "admin";

               System.out.print("Электрондук почтанызды жазыныз: ");
               scanner.nextLine();
               String email = scanner.nextLine();

               System.out.print("Пароль жазыныз: ");
               String password = scanner.nextLine();
               if (email.equals(registeredEmail)) {
                   if (password.equals(registeredPassword)) {
                       System.out.println("Welcome ! ");
                       break;
                   } else {
                       System.out.println("Почта же пароль туура эмес! ");
                   }
               } else {
                   System.out.println("Почта же пароль туура эмес! ");
               }
           }else if (number == 2) {
               System.out.println("Пароль озгортуу функциясы азыр жеткиликтуу эмес.");
           } else {
               System.out.println("Туура эмес буйрук. Кайрадан аракет кылыныз.");
           }
       }

        GroupService groupService = new GroupServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        LessonService lessonService = new LessonServiceImpl();


        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("***  Бир команда танданыз!  ***:   ");
                System.out.println("1 -> Add new group ");
                System.out.println("2 -> Get group by name  ");
                System.out.println("3 -> Update group name  ");
                System.out.println("4 -> Get all groups  ");
                System.out.println("5 -> Add new student to group  ");
                System.out.println("6 -> Update student  ");
                System.out.println("7 -> Find student by first name  ");
                System.out.println("8 -> Get all students by group name  ");
                System.out.println("9 -> Get all student's lesson   ");
                System.out.println("10 -> Delete student   ");
                System.out.println("11 -> Add new lesson to group  ");
                System.out.println("12 -> Get lesson by name ");
                System.out.println("13 -> Get all lesson by group name ");
                System.out.println("14 -> Delete lesson ");
                System.out.println("15 -> Delete group ");


                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        try {
                            System.out.print("Жаны группага ат жазыныз : ");
                            String groupName = scanner.nextLine();
                            System.out.print("Группанын суроттомосун жазыныз: ");
                            String groupDescription = scanner.nextLine();
                            Group group = new Group(GenerateId.getGroupId(), groupName, groupDescription);
                            System.out.println(group);
                            System.out.println("Add new group: " + groupService.addGroup(group));
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            System.out.print("Группанын атын жазыныз: ");
                            String name = scanner.nextLine();
                            System.out.println("Get group by name: " + groupService.getGroupByName(name));
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            System.out.println("Группанын атын жазыныз: ");
                            String groupName = scanner.nextLine();
                            System.out.println("Жаны ат жазыныз: ");
                            String newName = scanner.nextLine();
                            System.out.println("Update group name  : " + groupService.updateGroupName(groupName, newName));
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                            ;
                        }
                    }
                    case 4 -> {
                        System.out.println("Get all groups  : " + groupService.getAllGroups());
                    }
                    case 5 -> {
                        System.out.print("Студентти кошо турган группанын атын жазыныз: ");
                        String groupName = scanner.nextLine();
                        System.out.print("Студенттин атын жазыныз: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Фамилиясын жазыныз: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Электрондук почтасын жазыныз: ");
                        String email = scanner.nextLine();
                        System.out.print("Пароль ойлоп табыныз (7 символдон аз болбосун) : ");
                        String password = scanner.nextLine();
                        System.out.print("Жынысын жазыныз (MALE/FEMALE): ");
                        String genderInput = scanner.nextLine();
                        Gender gender = Gender.valueOf(genderInput.toUpperCase());
                        Student newStudent = new Student(GenerateId.getGroupId(), firstName, lastName, email, password, gender);
                        System.out.println(newStudent);
                        System.out.println("Add new student to group  : " + studentService.addStudentToGroup(groupName, newStudent));
                    }
                    case 6 -> {
                        System.out.println("Электрондук почтасын жазыныз:");
                        String email = scanner.nextLine();

                        System.out.println("Жаны пароль жазыныз:");
                        String newPassword = scanner.nextLine();

                        System.out.println("Жаны ат жазыныз:");
                        String firstName = scanner.nextLine();

                        System.out.println("Жаны фамилия жазыныз:");
                        String lastName = scanner.nextLine();

                        System.out.println("Жынысын жазыныз (MALE/FEMALE):");
                        String genderInput = scanner.nextLine();
                        Gender gender = Gender.valueOf(genderInput.toUpperCase());

                        Student updatedStudent = new Student(GenerateId.getStudentId(), firstName, lastName, email, newPassword, gender);
                        System.out.println(updatedStudent);
                        System.out.println("Update student: " + studentService.updateStudent(email, updatedStudent));
                    }
                    case 7 -> {
                        System.out.print("Студенттин атын жазыныз: ");
                        String firstName = scanner.nextLine();
                        System.out.println("Find student by first name : " + studentService.findByFirstName(firstName));
                    }
                    case 8 -> {
                        System.out.print("Группанын атын жазыныз: ");
                        String groupName = scanner.nextLine();
                        System.out.println("Get all students by group name: " + studentService.getAllStudentsByGroupName(groupName));
                    }
                    case 9 -> {
                        System.out.print("Студенттин почтасын жазыныз: ");
                        String email = scanner.nextLine();
                        System.out.println("Get all student's lesson : " + studentService.getStudentLessons(email));
                    }
                    case 10 -> {
                        try {
                            System.out.print("Студенттин атын жазыныз: ");
                            String name = scanner.nextLine();
                            System.out.println("Delete student: " + studentService.deleteStudent(name));
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                            ;
                        }
                    }
                    case 11 -> {
                        System.out.print("Группанын атын жазыныз: ");
                        String groupName = scanner.nextLine();
                        System.out.print("Сабактын атын жазыныз: ");
                        String lessonName = scanner.nextLine();
                        System.out.print("Сабактын суроттомосун жазыныз: ");
                        String taskDescription = scanner.nextLine();
                        Lesson lesson = new Lesson(GenerateId.getLessonId(), lessonName, taskDescription);
                        System.out.println(lesson);
                        System.out.println("Add new lesson to group   : " + lessonService.addLessonToGroup(groupName, lesson));
                    }
                    case 12 -> {
                        System.out.println("Сабактын атын жазыныз: ");
                        String lessonName = scanner.nextLine();
                        System.out.println("Get lesson by name: " + lessonService.getLessonByName(lessonName));
                    }
                    case 13 -> {
                        System.out.print("Группанын атын жазыныз: ");
                        String groupName = scanner.nextLine();
                        System.out.println("Get all lesson by group name: " + lessonService.getAllLessonByGroupName(groupName));
                    }
                    case 14 -> {
                        System.out.println("Сабактын атын жазыныз: ");
                        String lessonName = scanner.nextLine();
                        System.out.println("Delete student: " + lessonService.deleteLesson(lessonName));
                    }
                    case 15 -> {
                        try {
                            System.out.println("Группанын атын жазыныз: ");
                            String groupName = scanner.nextLine();
                            System.out.println("Delete group: " + groupService.deleteGroup(groupName));
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    default -> System.out.println("Туура эмес тандоо. Кайра аракет кылыныз.");

                }
            }
        }catch (InputMismatchException e){
            System.out.println("Киргизилген маалымат сан эмес ! ");

        }finally {
            System.out.println(" Operation is over!");
        }



















    }
}