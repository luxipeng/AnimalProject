package web.servlet;

import domain.Animal;
import service.AnimalService;
import service.impl.AnimalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setPidServlet")
public class SetPidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String pid = request.getParameter("pid");
        //2.调用Service查询
        request.setAttribute("pid",pid);
        //4.转发到update.jsp
        request.getRequestDispatcher("/addCase.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}