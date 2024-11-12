package com.UniversityLibrary;

public class Teacher extends User {
    private String profession;

    //Constructor
    public Teacher(String name, String id, char gender, String profession){
        super(name, id, gender);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
}