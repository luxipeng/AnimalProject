package service.impl;
import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import domain.Doctor;
import domain.PageBean;
import service.CustomerService;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao=new CustomerDaoImpl();
    @Override
    public List<Customer> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    public Doctor login(Doctor doctor){
        return dao.findDoctorByUsernameAndPassword(doctor.getNumber(),doctor.getPassword());
    }

    @Override
    public void addCustomer(Customer customer) {
        dao.addCustomer(customer);
    }

    @Override
    public int deleteCustomer(String Cid) {
        return dao.deleteCustomer(Cid);
    }

    @Override
    public Customer findCustomerById(String Cid) {
        Customer customer=dao.findCustomerById(Cid);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        dao.updateCustomer(customer);
    }

    @Override
    public void delSelectedCustomer(String[] Cids) {
        //不仅要在前台判断是否勾选了，在后台也要判断
        //防止出现空指针异常
        if (Cids!=null && Cids.length>0){
            //1.遍历数组
            for (String Cid : Cids) {
                //2.调用dao删除
                dao.deleteCustomer(Cid);
            }
        }
    }

    @Override
    public PageBean<Customer> findCustomerByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);

        int totalCount=dao.findTotalCount(condition);
        System.out.println("目前查询到的"+totalCount);
        if (totalCount==0){
            PageBean<Customer> pb=new PageBean<Customer>();
            pb=null;
            return pb;
        }else {
            int totalPage=(totalCount % rows)==0 ? (totalCount / rows) : (totalCount / rows +1);

            if (currentPage<=0){
                currentPage=1;
            }
            if(currentPage>totalPage){
                currentPage=totalPage;
            }
            //1.创建空的PageBean对象
            PageBean<Customer> pb=new PageBean<Customer>();

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
            List<Customer> list=dao.finByPage(start,rows,condition);

            pb.setList(list);

            //5.计算总页码
            // int totalPage=(totalCount % rows)==0 ? (totalCount / rows) : (totalCount / rows +1);
            pb.setTotalPage(totalPage);

            //6.返回PageBean对象
            return pb;
        }

    }
}