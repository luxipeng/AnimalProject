package web.servlet;
import domain.Doctor;
import domain.PageBean;
import service.DoctorService;
import service.impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findDoctorByPageServlet")
public class FindDoctorByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        //1.接收请求参数 currentPage，rows
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if (currentPage ==null ||"".equals(currentPage)){
            currentPage="1";
        }
        if (rows ==null ||"".equals(rows)){
            rows="5";
        }

        //获取条件查询参数   (设置debug在此处发现condition的size为0，没有获取到值)
        //只有两种情况：①jsp中提交的form表单没写action提交到此处的位置 ②form表单中input属性没加name
        Map<String, String[]> condition = request.getParameterMap();  //是查询表单中提交过来的数据
        System.out.println("自己设"+condition);
        //2.调用service查询PageBean
        DoctorService service=new DoctorServiceImpl();
        PageBean<Doctor> pb=service.findDoctorByPage(currentPage,rows,condition);
       System.out.println(pb);  // 在设置前端页面显示前先进行测试，浏览器直接访问该servlet页面，在网址栏内自行传值。?currentPage=1&rows=5
        //3.将PageBean存入request
        request.setAttribute("pb",pb);   //转发到了list中，在list.jsp页面中的el表达式就可以用pb里面存的东西
        request.setAttribute("condition",condition); //将查询条件存入request
        //4.转发list.jsp
        request.getRequestDispatcher("/listDoctor.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}