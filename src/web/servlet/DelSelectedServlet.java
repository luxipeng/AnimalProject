package web.servlet;

import service.CustomerService;
import service.impl.CustomerServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有id
        String[] ids = request.getParameterValues("cid");
        //2.调用service删除
        CustomerService service=new CustomerServiceImpl();
        service.delSelectedCustomer(ids);      //Servlet只作为控制器传递，先不进行遍历传递，先直接将数组传递过去
        //3.跳转查询所有Servlet,没有共享数据，直接重定向
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
