import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = {"/sum", "/tong"})
public class SumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float num1 = Float.parseFloat(req.getParameter("num1"));
        float num2 = Float.parseFloat(req.getParameter("num2"));
        float sum = num1 + num2;
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.print("<h2>Tong 2  so la  : " + sum + " </h2>");
        // trả về cho trang jsp để hiện thị.
        req.setAttribute("tong", sum);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("hien-thi-ket-qua.jsp");
        requestDispatcher.forward(req,resp);


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("phuong thuc init hoat dong");
    }

    @Override
    public void destroy() {
        System.out.println("phuong thuc destroy hoat dong");
    }
}
