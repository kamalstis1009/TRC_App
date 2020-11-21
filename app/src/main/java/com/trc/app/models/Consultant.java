package com.trc.app.models;

public class Consultant {

    private String name;
    private String birth;
    private String designation;
    private String phone;
    private String email;
    private String experience;
    private String qualification;

    public Consultant(String name, String birth, String designation, String phone, String email, String experience, String qualification) {
        this.name = name;
        this.birth = birth;
        this.designation = designation;
        this.phone = phone;
        this.email = email;
        this.experience = experience;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
