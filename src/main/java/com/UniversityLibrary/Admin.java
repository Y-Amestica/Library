package com.UniversityLibrary;

public class Admin extends User {
    private String role;

    public Admin(String name, String id, char gender, String role) {
        super(name, id, gender);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", gender=" + getGender() +
                ", role='" + role + '\'' +
                '}';
    }
}
