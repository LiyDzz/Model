package com.example.greendaotest;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.db.DaoMaster;
import com.example.db.DaoSession;
import com.example.db.Student;
import com.example.db.StudentDao;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.et_number)
    EditText etNumber;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_sex)
    EditText etSex;
    @Bind(R.id.et_age)
    EditText etAge;
    @Bind(R.id.bt_save)
    Button btSave;
    @Bind(R.id.bt_delete)
    Button btDelete;
    @Bind(R.id.bt_update)
    Button btUpdate;
    @Bind(R.id.bt_query)
    Button btQuery;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "Student.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        studentDao = daoSession.getStudentDao();
    }

    @OnClick({R.id.bt_save, R.id.bt_delete, R.id.bt_update, R.id.bt_query})
    public void onViewClicked(View view) {

        String number = etNumber.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String sex = etSex.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        Student student = new Student();
        student.setNumber(number);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);


        switch (view.getId()) {
            case R.id.bt_save:
                long insert = studentDao.insert(student);
                Log.e("AAA", "插入了" + insert + "行数据");
                break;
            case R.id.bt_delete:
                Student student11 = new Student();
                student.setId(1L);
                studentDao.delete(student11);
                break;
            case R.id.bt_update:
                Student stu = new Student();
                stu.setId(3L);
                stu.setName("韩韩");
                stu.setAge("25");
                stu.setSex("bunanbunv");
                studentDao.update(stu);

                break;
            case R.id.bt_query:
                QueryBuilder<Student> studentQueryBuilder = studentDao.queryBuilder();
                Query<Student> build = studentQueryBuilder.where(StudentDao.Properties.Name.eq("韩韩")).build();
                List<Student> list = build.list();
                for (Student student1:list){
                    Log.e("tag","名字为："+student1.getName());
                }
                break;
        }
    }
}
