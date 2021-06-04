package web.servlet;

import service.AnimalService;
import service.impl.AnimalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delAnimalServlet")
public class DelAnimalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数，id(不同的id对应不同的用户) 是int型的，不是中文，所以不用设置编码了
        String pid = request.getParameter("pid");     ///此处要注意，是上一个页面(listAnimal)中?后面传递过来的参数
        //2.调用service删除
        AnimalService service=new AnimalServiceImpl();
        service.deleteAnimal(pid);
        //3.跳转查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findAnimalByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
