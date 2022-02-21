package thi_module2.model;

public class Teacher {
    private int id;
    private String name;
    private int date;
    private String sex;
    private int phone;

    public Teacher() {
    }

    public Teacher(int id, String name, int date, String sex, int phone) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return getId()+","+getName()+","+getDate()+","+getSex()+","+getPhone();
    }
}
