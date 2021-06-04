package web.servlet;

import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数，id(不同的id对应不同的用户) 是int型的，不是中文，所以不用设置编码了
        String id = request.getParameter("id");
        //2.调用service删除
        CustomerService service=new CustomerServiceImpl();
        int a = service.deleteCustomer(id);
        if(a==1){ //删除成功
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
        }else if(a==2){//删除主人失败
            //提示信息
            System.out.println("执行了吗？");
            request.setAttribute("addError","error");
            //跳转登陆页面
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
