package ss6_inheritance_in_java.bai_tap.lop_circle_va_lop_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5);
        System.out.println(cylinder);
        Cylinder cylinder1 = new Cylinder(8,"red",7);
        System.out.println(cylinder1);
        cylinder1.setHeight(6.5);
        System.out.println("Change height ="+cylinder1.getHeight());
        System.out.println("New Volume = "+cylinder1.getVolume());
    }
}
