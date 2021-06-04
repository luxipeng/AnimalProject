package web.servlet;

import domain.Animal;
import domain.History;
import org.apache.commons.beanutils.BeanUtils;
import service.AnimalService;
import service.impl.AnimalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet("/addHistoryServlet")

public class AddHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取所有数据
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        History history=new History();
        try {
            BeanUtils.populate(history,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service完成保存
        AnimalService service=new AnimalServiceImpl();
        int a = service.addHistory(history); //返回值为2时执行了catch异常，表示添加失败，返回值为1表示添加成功
        if(a==1){ //添加成功
            //5.跳转到userListServlet,再次查询  没有共享数据，直接重定向过来
            response.sendRedirect(request.getContextPath()+"/findAnimalByPageServlet");
        }else if(a==2){//添加动物失败
            //wrong();
            //提示信息
            request.setAttribute("addError","error");
            //跳转登陆页面
            request.getRequestDispatcher("/addAnimal.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}