package dao;

import models.Lesson;

import java.util.Set;

public interface LessonDao {

    String addLessonToGroup(String groupName, Lesson lesson);

    Lesson getLessonByName(String lessonName);

    Set<Lesson> getAllLessonByGroupName(String name);

    String deleteLesson(String lessonName);



}
