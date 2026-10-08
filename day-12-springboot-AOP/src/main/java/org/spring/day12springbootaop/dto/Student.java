package org.spring.day12springbootaop.dto;

public class Student {
    private String name;
    private int age;
    private int rollNo;
    private String mesasage;

    public String getMesasage() {
        return mesasage;
    }

    public void setMesasage(String mesasage) {
        this.mesasage = mesasage;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
