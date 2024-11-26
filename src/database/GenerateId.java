package database;

public class GenerateId {

    public static Long groupId = 0L;

    public static Long lessonId = 0L;

    public static Long studentId = 0L;


    public static Long getGroupId(){
        return ++groupId;
    }

    public static Long getLessonId(){
        return ++lessonId;
    }

    public static Long getStudentId(){
        return ++studentId;
    }

}
