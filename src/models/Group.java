package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    private Long id;
    private String groupName;
    private String description;
    private Set<Lesson> lessons= new HashSet<>();
    private Set<Student> students= new HashSet<>();

    public Group() {
    }

    public Group(Long id, String groupName, String description, Set<Lesson> lessons, Set<Student> students) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }

    public Group(Long id, String groupName, String description) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "\nid=" + id +
                ", \ngroupName='" + groupName + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \nlessons=" + lessons +
                ", students=" + students +
                '}';
    }
}
