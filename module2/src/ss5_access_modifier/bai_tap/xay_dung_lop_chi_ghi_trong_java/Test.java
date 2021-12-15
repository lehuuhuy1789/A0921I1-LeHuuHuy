package ss5_access_modifier.bai_tap.xay_dung_lop_chi_ghi_trong_java;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Huy");
        student.setClasses("A09I21");
        System.out.println(student.getName()+" - "+student.getClasses());
    }
}
