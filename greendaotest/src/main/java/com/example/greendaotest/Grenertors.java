package com.example.greendaotest;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

/**
 * Created by 李艳东 on 2017/4/18.
 */

public class Grenertors {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.db");
        Entity entity = schema.addEntity("Student");
        entity.addIdProperty();
        entity.addStringProperty("name");
        entity.addStringProperty("number");
        entity.addStringProperty("sex");
        entity.addStringProperty("age");

        try {
            new DaoGenerator().generateAll(schema, "E:\\AndroidStudioCodeGaoji\\Day10ORMLiteTest\\greendaotest\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
