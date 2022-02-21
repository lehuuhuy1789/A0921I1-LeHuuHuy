package thi_module2.model;

public class Student extends Teacher {
    private int idClass;

    public Student() {
    }

    public Student(int id, String name, int date, String sex, int phone, int idClass) {
        super(id, name, date, sex, phone);
        this.idClass = idClass;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    @Override
    public String toString() {
        return getId()+","+getName()+","+getDate()+","+getSex()+","+getPhone()+","+getIdClass();
    }
}
