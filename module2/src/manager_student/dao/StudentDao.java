package manager_student.dao;

import manager_student.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Huy", 21, "Đà Nẵng", 7, "Ngữ Văn"));
        students.add(new Student(2, "Khánh", 22, "Đà Nẵng", 8, "Toán"));
        students.add(new Student(3, "Hoàng", 23, "Đà Nẵng", 9, "Ngoại ngữ"));
        students.add(new Student(4, "Việt", 24, "Đà Nẵng", 10, "Sinh học"));
    }

    public static List<Student> getStudents() {
        return students;
    }
}
