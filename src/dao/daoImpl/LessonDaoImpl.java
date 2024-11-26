package dao.daoImpl;

import dao.LessonDao;
import database.Database;
import models.Group;
import models.Lesson;

import java.util.HashSet;
import java.util.Set;

public class LessonDaoImpl implements LessonDao {

    Database database = new Database();


    @Override
    public String addLessonToGroup(String groupName, Lesson lesson) {
        if (lesson == null) {
            return "Сабак бош боло албайт.";
        }

        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                if (group.getLessons() == null) {
                    group.setLessons(new HashSet<>());
                }
                group.getLessons().add(lesson);
                Database.lessons.add(lesson);
                return "Сабак кошулган группа : " + group.getGroupName();
            }
        }
        return "Мындай " + groupName + " аттуу группа табылган жок. ";
    }

    @Override
public Lesson getLessonByName(String lessonName) {
    try {
        if (lessonName == null || lessonName.trim().isEmpty()) {
            System.out.println("Error: Сабактын аты бош болбошу керек. ");
            return null;
        }
        for (Group group : Database.groups) {
            if (group.getLessons() != null) {
                for (Lesson lesson : group.getLessons()) {
                    if (lesson.getLessonName().equalsIgnoreCase(lessonName)) {
                        return lesson;
                    }
                }
            }
        }
        System.out.println("Мындай " + lessonName + " аттуу сабак табылган жок.");
    } catch (Exception e) {
        System.out.println("Кутуусуз ката: " + e.getMessage());
    }

    return null;
}




    @Override
    public Set<Lesson> getAllLessonByGroupName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Группанын аты бош боло албайт.");
            }
            for (Group group : Database.groups) {
                if (group.getGroupName().equalsIgnoreCase(name)) {
                    return group.getLessons() != null ? group.getLessons() : Set.of();
                }
            }
            throw new IllegalArgumentException("Мындай " + name + " аттуу группа табылган жок.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return Set.of();
        } catch (Exception e) {
            System.out.println("Кутуусуз ката: " + e.getMessage());
            return Set.of();
        }
    }


    @Override
    public String deleteLesson(String lessonName) {
        try {
            if (lessonName == null || lessonName.trim().isEmpty()) {
                throw new IllegalArgumentException("Сабактын аты бош боло албайт.");
            }
            for (Group group : Database.groups) {
                Set<Lesson> lessons = group.getLessons();
                if (lessons != null) {
                    for (Lesson lesson : new HashSet<>(lessons)) {
                        if (lesson.getLessonName().equalsIgnoreCase(lessonName)) {
                            lessons.remove(lesson);
                            Database.lessons.remove(lesson);
                            return  lessonName + " аттуу сабак очурулгон группа бул: " + group.getGroupName();
                        }
                    }
                }
            }
            throw new IllegalArgumentException( lessonName + " аттуу сабак табылган жок.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            System.out.println("Кутуусуз ката: " + e.getMessage());
            return "Кутуусуз ката.";
        }
    }






    }

