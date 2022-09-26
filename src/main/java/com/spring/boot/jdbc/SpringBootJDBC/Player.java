package com.spring.boot.jdbc.SpringBootJDBC;


import javax.xml.crypto.Data;
import java.util.Date;

public class Player
{
    private int pid;
    private String name;
    private int age;
    private String nationality;
    private Date dob;
    private int designation;

    public Player()
    {

    }
    public Player(int pid, String name, int age, String nationality, Date dob, int designation)
    {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.dob = dob;
        this.designation = designation;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getDesignation() {
        return designation;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", dob=" + dob +
                ", designation=" + designation +
                '}';
    }
}
