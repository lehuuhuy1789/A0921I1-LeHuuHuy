package model.repository;

import model.bean.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    void add(Student student);
    void delete(String id);
}
