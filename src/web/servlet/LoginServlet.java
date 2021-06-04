package web.servlet;

import domain.Customer;
import domain.Doctor;
import org.apache.commons.beanutils.BeanUtils;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        //2.1获取用户填写验证码
        String verifycode = request.getParameter("verifycode");
        //3.校验验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if (checkcode_server.equalsIgnoreCase(verifycode)){
            //4.获取用户输入的账号密码
            Map<String,String[]> map= request.getParameterMap();
            //5.封装User对象
            Doctor doctor=new Doctor();
            try {
                BeanUtils.populate(doctor,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //6.调用Service查询
            CustomerService service=new CustomerServiceImpl();
            Doctor loginUser = service.login(doctor);
            //7.判断是否登陆成功
            if(loginUser !=null){
                //登陆成功
                //将用户存入session
                session.setAttribute("user",loginUser);
                //跳转页面
//                response.sendRedirect(request.getContextPath()+"/index.jsp");
                response.sendRedirect(request.getContextPath()+"/mainfunction.jsp");

            }else{
                //登陆失败
                //提示信息
                request.setAttribute("login_msg","账号或密码错误！");
                //跳转登陆页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            //做到这步可以先测试一下，再继续往下写。
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}