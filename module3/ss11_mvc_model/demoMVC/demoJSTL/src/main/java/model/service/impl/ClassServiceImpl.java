package model.service.impl;

import model.bean.StudentClass;
import model.repository.ClassRepository;
import model.repository.impl.ClassRepositoryImpl;
import model.service.ClassService;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository = new ClassRepositoryImpl();
    @Override
    public List<StudentClass> findAll() {
        return classRepository.findAll();
    }
}
