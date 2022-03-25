package controller;

import model.bean.Student;
import model.bean.StudentClass;
import model.service.ClassService;
import model.service.StudentService;
import model.service.impl.ClassServiceImpl;
import model.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controller.StudentServlet" , urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
   private StudentService studentService = new StudentServiceImpl();
   private ClassService classService = new ClassServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                // Lưu vào database
                save(request,response);
                break;
            case "edit":
                // chỉnh sửa
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                // hien thi danh sách
        }



    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender =Boolean.parseBoolean(request.getParameter("gender"));
        String birthday =request.getParameter("birthday");
        int point =Integer.parseInt(request.getParameter("point"));
        String account =request.getParameter("account");
        int classId=Integer.parseInt(request.getParameter("classId"));
        String email = request.getParameter("email");
        Student student = new Student(id,name,gender,birthday,point,account,classId,email);
        studentService.add(student);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                // trả về một form thêm mới
                showFormCreate(request,response);
                break;
            case "edit":
                // chỉnh sửa
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                showStudentList(request,response);
                // hien thi danh sách
        }



    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {

        // trả về form thêm mới
        request.setAttribute("classList", classService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        request.setAttribute("studentList",studentService.findAll());
        request.setAttribute("classList",classService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
