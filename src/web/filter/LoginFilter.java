package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转化   子类HttpServletRequest中才有查询uri的方法
        HttpServletRequest request = (HttpServletRequest) req;

        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源  要注意排除css/js/图片/验证码等资源，否则界面是很单一的字，没有样式
        if (uri.contains("/login.jsp") ||uri.contains("/loginServlet")|| uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/checkCodeServlet")||uri.contains("image/")){
            //包含，证明用户就是想登录，直接放行
            chain.doFilter(req, resp);
        }else {
            //不包含，需要验证用户是否登录
            //3.从session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user !=null){
                //证明用户已经登录，放行
                chain.doFilter(req, resp);
            }else {
                //没有登录，跳转登录界面
                request.setAttribute("login_msg","您还没有登录！请先登录！");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
