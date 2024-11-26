package models;

import enums.Gender;

import java.util.List;
import java.util.Set;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
   private Gender gender;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String email, String password, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "\nid=" + id +
                ", \nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \nemail='" + email + '\'' +
                ", \npassword='" + password + '\'' +
                ", \ngender=" + gender +
                '}';
    }
}
