package com.sh.pojo;

public class Equip {

    private String name;

    private String type;

    private String grade;

    private boolean exist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public Equip(String grade) {
        this.grade = grade;
    }

    public Equip() {
    }
}
