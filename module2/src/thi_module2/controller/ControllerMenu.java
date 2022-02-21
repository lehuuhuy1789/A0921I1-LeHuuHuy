package thi_module2.controller;

import case_study.services.impl.EmployeeServiceImpl;
import thi_module2.service.StudentService;
import thi_module2.service.TeacherService;

import java.util.Scanner;

public class ControllerMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentService();
    private static TeacherService teacherService = new TeacherService();
    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu(){
        String tmp="";
        int choose = 0;
        do {
            System.out.println("  --CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN-- "+
                    "\n Chọn chức năng theo số (để tiếp tục): "+
                    "\n1.Thêm mới sinh viên" +
                    "\n2.Xóa sinh viên " +
                    "\n3.Xem danh sách sinh viên" +
                    "\n4.Xem thông tin sinh viên"+
                    "\n5.Tìm kiếm sinh viên"+
                    "\n6.Thoát"+
                    "\nChọn chức năng");
            tmp = scanner.nextLine();
            if (validateNumber(tmp)) {
                choose = Integer.parseInt(tmp);
            }
        }while (choose <= 0 || choose > 8);
        switch (choose){
            case 1:
                //createTeacherOrStudent();
                break;
            case 2:
                //displayTeacherOrStudent();
                break;
            case 3:
                //editTeacherOrStudent();
                break;
            case 4:
                //deleteTeacherOrStudent();
                break;
            case 5:
                //searchByNameTeacherOrStudent();
                break;
            case 6:
                //searchByAgeTeacherOrStudent();
                break;
            case 7:
                //sortTeacherOrStudent();
                break;
            case 8:
                System.exit(0);
                break;
        }
        backToMenu();
    }
    public static void addStudent(){
        boolean flag = true;
        StudentService studentService = new StudentService();
        do {
            System.out.println(
                    "\nDisplay list student" +
                            "\n1.Thêm mới sinh viên" +
                            "\n2.Chỉnh sửa thông tin sinh viên" +
                            "\n3.Xóa sinh viên"+
                            "\n4.Thoát");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    studentService.create();
                    break;
                case 2:
                    studentService.edit();
                    break;
                case 3:
                    studentService.delete();
                    break;
                case 4:
                    backToMenu();
                    break;
            }
        }while (flag);
    }

//    public static void displayTeacherOrStudent(){
//        String tmp="";
//        int choose = 0;
//        do {
//            System.out.println("Chọn đối tượng cần hiển thị: "+
//                    "\n1.Student" +
//                    "\n2.Teacher" );
//            System.out.println(tmp.isEmpty()?"Nhập đối tượng cần thực hiện":"Vui lòng nhập số từ 1-2");
//            tmp = scanner.nextLine();
//            if (validateNumber(tmp)) {
//                choose = Integer.parseInt(tmp);
//            }
//        }while (choose <= 0 || choose > 2);
//        switch (choose){
//            case 1:
//                studentService.show();
//                break;
//            case 2:
//                teacherService.show();
//                break;
//        }
//    }
//
//    public static void editTeacherOrStudent(){
//        String tmp="";
//        int choose = 0;
//        do {
//            System.out.println("Chọn đối tượng cần chỉnh sửa "+
//                    "\n1.Student" +
//                    "\n2.Teacher" );
//            System.out.println(tmp.isEmpty()?"Nhập đối tượng cần thực hiện":"Vui lòng nhập số từ 1-2");
//            tmp = scanner.nextLine();
//            if (validateNumber(tmp)) {
//                choose = Integer.parseInt(tmp);
//            }
//        }while (choose <= 0 || choose > 2);
//        switch (choose){
//            case 1:
//                studentService.edit();
//                break;
//            case 2:
//                teacherService.edit();
//                break;
//        }
//    }
//
//    public static void deleteTeacherOrStudent(){
//        String tmp="";
//        int choose = 0;
//        do {
//            System.out.println("Chọn đối tượng cần xóa: "+
//                    "\n1.Student" +
//                    "\n2.Teacher" );
//            System.out.println(tmp.isEmpty()?"Nhập đối tượng cần thực hiện":"Vui lòng nhập số từ 1-2");
//            tmp = scanner.nextLine();
//            if (validateNumber(tmp)) {
//                choose = Integer.parseInt(tmp);
//            }
//        }while (choose <= 0 || choose > 2);
//        switch (choose){
//            case 1:
//                studentService.delete();
//                break;
//            case 2:
//                teacherService.delete();
//                break;
//        }
//    }
//
//    public static void searchByNameTeacherOrStudent(){
//        String tmp="";
//        int choose = 0;
//        do {
//            System.out.println("Chọn đối tượng cần tìm kiếm theo tên: "+
//                    "\n1.Student" +
//                    "\n2.Teacher" );
//            System.out.println(tmp.isEmpty()?"Nhập đối tượng cần thực hiện":"Vui lòng nhập số từ 1-2");
//            tmp = scanner.nextLine();
//            if (validateNumber(tmp)) {
//                choose = Integer.parseInt(tmp);
//            }
//        }while (choose <= 0 || choose > 2);
//    }
//
//    public static void sortTeacherOrStudent(){
//        String tmp="";
//        int choose = 0;
//        do {
//            System.out.println("Chọn đối tượng cần sắp xếp: "+
//                    "\n1.Student" +
//                    "\n2.Teacher" );
//            System.out.println(tmp.isEmpty()?"Nhập đối tượng cần thực hiện":"Vui lòng nhập số từ 1-2");
//            tmp = scanner.nextLine();
//            if (validateNumber(tmp)) {
//                choose = Integer.parseInt(tmp);
//            }
//        }while (choose <= 0 || choose > 2);
//        switch (choose){
//            case 1:
//                studentService.sort();
//                break;
//            case 2:
//                teacherService.sort();
//                break;
//        }
//    }
    public static void backToMenu(){
        System.out.println("Bạn có muốn quay lại menu (Y/N): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")){
            displayMenu();
        } else {
            System.exit(0);
        }
    }
    public static boolean validateNumber(String choose){
        String regex = "^[1-8]$";
        return choose.matches(regex);
    }

}
