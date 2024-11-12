package com.UniversityLibrary;

public class Student extends User {
    private String career;

    public Student(String name, String id, char gender, String career){
        super(name, id, gender);
        this.career = career;
    }
    public String getCareer(){
        return career;
    }
    public void setCareer(String career){
        this.career = career;
    }
}
