package web.servlet;

import domain.Customer;
import org.apache.commons.beanutils.BeanUtils;
import service.CustomerService;
import service.impl.CustomerServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取所有数据
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Customer customer=new Customer();
        try {
            BeanUtils.populate(customer,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service完成保存
        CustomerService service=new CustomerServiceImpl();
        service.addCustomer(customer);
        //5.跳转到userListServlet,再次查询  没有共享数据，直接重定向过来
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}