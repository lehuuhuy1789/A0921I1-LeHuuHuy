package model.service;

import model.bean.Student;
import model.bean.StudentClass;

import java.util.List;

public interface ClassService {
    List<StudentClass> findAll();
}
