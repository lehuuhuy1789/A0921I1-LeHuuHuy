package manager_student.model;

public class Student extends Person {
    private int point;
    private String subject;

    public Student(int id, String name, int date, String sex, int phone, int idClass) {

    }

    public Student(int id, String name, int age, String address, int point, String subject) {
        super(id, name, age, address);
        this.point = point;
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return " id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                ", point=" + point;
    }
}
