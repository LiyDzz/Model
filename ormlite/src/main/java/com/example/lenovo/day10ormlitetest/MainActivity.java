package com.example.lenovo.day10ormlitetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.number)
    EditText number;
    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.sex)
    EditText sex;
    @Bind(R.id.age)
    EditText age;
    @Bind(R.id.save)
    Button save;
    Dao<Student, Integer> dao;
    @Bind(R.id.delete)
    Button delete;
    @Bind(R.id.updata)
    Button updata;
    @Bind(R.id.qurey)
    Button qurey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyOpenHelper openHelper = new MyOpenHelper(this, "database.db", null, 1);
        try {
            dao = openHelper.getDao(Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.save)
    public void onViewClicked() {
        String Number = number.getText().toString().trim();
        String Name = name.getText().toString().trim();
        String Sex = sex.getText().toString().trim();
        String Age = age.getText().toString().trim();
        Student student = new Student(Number, Name, Sex, Age);
        try {
            dao.create(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.delete, R.id.updata, R.id.qurey})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.delete:
                Student student = new Student();
                student.setId(3);
                try {
                    int delete = dao.delete(student);
                    Log.e("tag", "删除了" + delete + "条数据");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.updata:
                Student student1 = new Student("1314", "韩韩", "女", "20");
                student1.setId(5);
                try {
                    int update = dao.update(student1);
                    Log.e("tag", "更改了" + update + "条数据");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.qurey:
                try {
                    List<Student> students = dao.queryForAll();
                    for (Student stu : students) {
                        Log.e("tag", "查询结果" + students.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
