package service.serviceImpl;

import dao.LessonDao;
import dao.daoImpl.LessonDaoImpl;
import models.Lesson;
import service.LessonService;

import java.util.Set;



public class LessonServiceImpl implements LessonService {

    LessonDao lessonDao =new LessonDaoImpl();


    @Override
    public String addLessonToGroup(String groupName, Lesson lesson) {
        return lessonDao.addLessonToGroup(groupName, lesson);
    }

    @Override
    public Lesson getLessonByName(String lessonName) {
        return lessonDao.getLessonByName(lessonName);
    }

    @Override
    public Set<Lesson> getAllLessonByGroupName(String name) {
        return lessonDao.getAllLessonByGroupName(name);
    }

    @Override
    public String deleteLesson(String lessonName) {
        return lessonDao.deleteLesson(lessonName);
    }


}
