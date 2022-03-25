package model.repository.impl;

import model.bean.Student;
import model.bean.StudentClass;
import model.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1, "tuấn", true, "12/12/2022", 9, "tuanvn", 1, "chanhtv235@gmial.com"));
        studentList.add(new Student(2, "trâm", false, "12/12/2022", 8, "tram", 2, "chanhtv235@gmial.com"));
        studentList.add(new Student(3, "lịch", true, "12/12/2022", 7, "lichhn", 2, "chanhtv235@gmial.com"));
        studentList.add(new Student(4, "hải", true, "12/12/2022", 6, "haitt", 3, "chanhtv235@gmial.com"));
        studentList.add(new Student(5, "chánh", true, "12/12/2022", 4, "chanhtv", 1, "chanhtv235@gmial.com"));
    }
    @Override
    public List<Student> findAll() {
        // kết nôi database để tra về dữ liệu
        return studentList;
    }

    @Override
    public void add(Student student) {

       studentList.add(student);
        System.out.println("them moi thanh cong");
    }

    @Override
    public void delete(String id) {

    }
}
