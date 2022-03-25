import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    // khi gửi bằng phưng thức post thì sẽ vào.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));

        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1> Hello - vao pt DOPOST </h1>");
        printWriter.print("<h1>"+ (n1+n2)+" </h1>");
    }
    // khi gửi băng phương thức get thì sẽ vào
         // + gõ trực tiếp trên thanh url của tình trình duyệt
         // + click vào một đường dẫn thẻ <a>
         // + sử dụng form với method =get
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));
        String name = request.getParameter("ten");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1> Hello "+name +" - vao pt DOGET </h1>");
        printWriter.print("<h1>"+ (n1+n2)+" </h1>");

    }
}
