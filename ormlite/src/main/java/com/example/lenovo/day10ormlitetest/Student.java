package com.example.lenovo.day10ormlitetest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 李艳东 on 2017/4/18.
 */
@DatabaseTable(tableName = "studet")
public class Student {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "number")
    private String number;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "sex")
    private String sex;
    @DatabaseField(columnName = "age")
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student() {
    }

    public Student(String number, String name, String sex, String age) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age='" + age + '\'' +
                ", id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
