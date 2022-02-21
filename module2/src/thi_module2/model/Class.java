package thi_module2.model;

public class Class {
    private int idClass;
    private String name;
    private int idTeacher;

    public Class() {
    }

    public Class(int idClass, String name, int idTeacher) {
        this.idClass = idClass;
        this.name = name;
        this.idTeacher = idTeacher;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "Class{" +
                "idClass=" + idClass +
                ", name='" + name + '\'' +
                ", idTeacher=" + idTeacher +
                '}';
    }
}
