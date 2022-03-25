package model.repository.impl;

import model.bean.Student;
import model.bean.StudentClass;
import model.repository.ClassRepository;

import java.util.ArrayList;
import java.util.List;

public class ClassRepositoryImpl implements ClassRepository {
    private static List<StudentClass> studentClassList = new ArrayList<>();
    static {
        studentClassList.add(new StudentClass(1,"A0821I1"));
        studentClassList.add(new StudentClass(2,"A0921I1"));
        studentClassList.add(new StudentClass(3,"A1021I1"));
    }
    @Override
    public List<StudentClass> findAll() {
        return studentClassList;
    }
}
