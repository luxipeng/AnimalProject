//package web.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 敏感词汇过滤器
// */
//@WebFilter("/*")
//public class SensitiveWordsFilter implements Filter {
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        //1.创建代理对象，增强getParameter方法
//       ServletRequest proxy_req=(ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                //增强getParameter方法
//                //判断是否是getParameter方法 (zhi姐获取值)
//                if (method.getName().equals("getParameter")){
//                    //增强返回值
//                    //获取返回值
//                   String value=(String) method.invoke(req,args);
//                   if (value!=null){
//                       for (String str : list) {
//                           if (value.contains(str)){
//                               value=value.replaceAll(str,"***");
//                           }
//                       }
//                   }
//                   return value;
//                }
//
//                //还需判断方法名是否是getParameterMap（从map中获取值）
//                //判断方法名是否是getParameterValue（从数组中获取值）
//                return method.invoke(req,args);
//            }
//        });
//        //2.放行
//        chain.doFilter(proxy_req, resp);
//
//    }
//
//    private List<String> list=new ArrayList<>();//敏感词汇的list集合
//    public void init(FilterConfig config) throws ServletException {
//        try {
//        //1.加载文件：获取文件真实路径
//        ServletContext servletContext = config.getServletContext();
//        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
//        //2.读取文件
//            BufferedReader br=new BufferedReader(new FileReader(realPath));
//        //3.将文件的每一行数据添加到list中
//            String line=null;
//            while ((line=br.readLine())!=null){
//                list.add(line);
//            }
//            br.close();
//            System.out.println(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void destroy() {
//    }
//}
