package thi_module2.service;



import thi_module2.model.Student;
import thi_module2.util.CSVHepler;

import java.util.*;

public class StudentService {
    private static List<Student> studentList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private CSVHepler<Student> studentCSVHepler = new CSVHepler<>();
    private final String path ="src/thi_module2/data/students.csv";

    public StudentService() {
        studentList = getAll();
    }

    public List<Student> getAll(){
        studentList.clear();
        List<String> lines = studentCSVHepler.read(path);
        for (String line:lines) {
            String[]arr = line.split(",");
            Student student1 = new Student(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]),arr[3],Integer.parseInt(arr[4]),Integer.parseInt(arr[5]));
            studentList.add(student1);
        }
        return studentList;
    }

    public void save(Student student){
        if (student.getId()>0){
            //edit
            int index = studentList.indexOf(student);
            studentList.set(index, student);
        } else {
            //add
            student.setId(studentList.size()+1);
            studentList.add(student);
        }
        studentCSVHepler.write(studentList,path);
    }

    public void inputAndSave(int id){
        boolean check;
        String name;
        do {
            System.out.println("Nhập tên sinh viên (viết hoa chữ cái đầu) ");
            name = scanner.nextLine();
            check = name.matches("^[A-Z][a-z4-50]+$");
        }while (!check);
        System.out.println("Nhập ngày sinh:");
        int date = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Nhập số điện thoại:");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã lớp học:");
        int idClass = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id,name,date,sex,phone,idClass);
        save(student);
    }
    public void create(){
        inputAndSave(0);
        System.out.println("Đã tạo thành công");

    }
    public void edit(){
        show();
        System.out.println("Nhập id bạn muốn edit");
        int id = Integer.parseInt(scanner.nextLine());
        inputAndSave(id);
        System.out.println("Chỉnh sửa thành công");

    }

    public void delete(int id){
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()){
                studentList.remove(i);
            }
        }
        studentCSVHepler.write(studentList, path);
    }
    public void delete(){
        show();
        System.out.println("Nhập ID bạn muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        delete(id);
        System.out.println("Bạn đã xóa thành công");
    }

    public void show(List<Student> studentList){
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID", "NAME", "DATE", "SEX", "PHONE", "IDCLASS");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (Student student:studentList) {
            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", student.getId(), student.getName(), student.getDate(), student.getSex(), student.getPhone(), student.getIdClass());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");

    }
    public void show(){
        show(studentList);
    }

    public void sort(){
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        show();
        System.out.println("Đã sắp xếp theo tên thành công");
    }
}
