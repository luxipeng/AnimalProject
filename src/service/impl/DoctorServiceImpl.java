package service.impl;
import dao.DoctorDao;
import dao.impl.DoctorDaoImpl;
import domain.Doctor;
import domain.PageBean;
import service.DoctorService;

import java.util.List;
import java.util.Map;

public class DoctorServiceImpl implements DoctorService {
    private DoctorDao dao=new DoctorDaoImpl();
    @Override
    public PageBean<Doctor> findDoctorByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);

        int totalCount=dao.findTotalCount(condition);
        int totalPage=(totalCount % rows)==0 ? (totalCount / rows) : (totalCount / rows +1);

        if (currentPage<=0){
            currentPage=1;
        }
        if(currentPage>totalPage){
            currentPage=totalPage;
        }
        //1.创建空的PageBean对象
        PageBean<Doctor> pb=new PageBean<Doctor>();

        //2.设置当前页面属性和rows属性
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        /*
        在加入条件查询之前，这个查询记录数是直接查全部的，没有传递参数
         */
        //3.调用dao查询totalCount总记录数
        //int totalCount=dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //4.调用dao查询list集合
        int start=(currentPage-1)*rows;
        List<Doctor> list=dao.finByPage(start,rows,condition);
        pb.setList(list);

        //5.计算总页码
       // int totalPage=(totalCount % rows)==0 ? (totalCount / rows) : (totalCount / rows +1);
        pb.setTotalPage(totalPage);

        //6.返回PageBean对象
        return pb;
    }
}