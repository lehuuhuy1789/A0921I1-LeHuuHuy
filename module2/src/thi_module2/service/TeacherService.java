package thi_module2.service;

import thi_module2.model.Teacher;
import thi_module2.util.CSVHepler;

import java.util.*;

public class TeacherService {
    private static List<Teacher> teacherList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private CSVHepler<Teacher> teacherCSVHepler = new CSVHepler<>();
    private final String path ="src/thi_module2/data/teachers.csv";
    Date date = new Date();

    public TeacherService() {
        teacherList = getAll();
    }

    public List<Teacher> getAll(){
        teacherList.clear();
        List<String> lines = teacherCSVHepler.read(path);
        for (String line:lines) {
            String[]arr = line.split(",");
            Teacher teacher = new Teacher(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]),arr[3],Integer.parseInt(arr[4]));
            teacherList.add(teacher);
        }
        return teacherList;
    }

    public void save(Teacher teacher){
        if (teacher.getId()>0){
            //edit
            int index = teacherList.indexOf(teacher);
            teacherList.set(index, teacher);
        } else {
            //add
            teacher.setId(teacherList.size()+1);
            teacherList.add(teacher);
        }
        teacherCSVHepler.write(teacherList,path);
    }

    public void inputAndSave(int id){
        boolean check;
        String name;
        do {
            System.out.println("Nhập tên Teacher (viết hoa chữ cái đầu) ");
            name = scanner.nextLine();
            check = name.matches("^[A-Z][a-z4-50]+$");
        }while (!check);

        System.out.println("Nhập ngày sinh giáo viên: ");
        int date = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        int phone = Integer.parseInt(scanner.nextLine());
        Teacher teacher = new Teacher(id,name,date,sex,phone);
        save(teacher);
    }
    public void create(){
        inputAndSave(0);
        System.out.println("Đã tạo thành công");

    }
    public void edit(){
        show();
        System.out.println("Nhập id bạn muốn sửa");
        int id = Integer.parseInt(scanner.nextLine());
        inputAndSave(id);
        System.out.println("Chỉnh sửa thành công");

    }

    public void delete(int id){
        for (int i = 0; i < teacherList.size(); i++) {
            if (id == teacherList.get(i).getId()){
                teacherList.remove(i);
            }
        }
        teacherCSVHepler.write(teacherList, path);
    }
    public void delete(){
        show();
        System.out.println("Nhập ID bạn muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        delete(id);
        System.out.println("Bạn đã xóa thành công");
    }

    public void show(List<Teacher> teacherList){
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", "ID", "NAME", "DATE", "SEX", "PHONE");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (Teacher teacher:teacherList) {
            System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", teacher.getId(), teacher.getName(), teacher.getDate(), teacher.getSex(), teacher.getPhone());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");

    }
    public void show(){
        show(teacherList);
    }

    public void sort(){
        Collections.sort(teacherList, Comparator.comparing(Teacher::getName));
        show();
        System.out.println("Đã sắp xếp theo tên thành công");
    }
}
