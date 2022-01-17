package manager_student.service;

import manager_student.dao.StudentDao;
import manager_student.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements CRUDInterface<Student> {
    // thêm, sửa, xóa, hiển thị thông tin của Student

    private ArrayList<Student> students = (ArrayList<Student>) StudentDao.getStudents();

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void add(Student student) {
        System.out.println("Nhập tên SV");
        String name = scanner.nextLine();
        System.out.println("Nhập tên tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập Point");
        int point = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập môn học");
        String subject = scanner.nextLine();
        Student student1 = new Student(id,name,age,address,point,subject);
        List<Student> studentList = new ArrayList<>(); // do tạo danh sách rỗng add vào nên cần append:true, nếu để mặc định (false) nó sẽ ghi đè
        studentList.add(student1);
    }

    @Override
    public void edit(Student student, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
