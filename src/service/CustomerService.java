package service;

import domain.Customer;
import domain.Doctor;
import domain.PageBean;

import java.util.List;
import java.util.Map;

//用户管理的业务接口
public interface CustomerService {
    /*
    查询所有用户信息
     */
    public List<Customer> findAll();
    public Doctor login(Doctor doctor);

    /*
    添加用户信息
     */
    public void addCustomer(Customer customer);

    /*
    根据id删除用户信息
     */
    public int deleteCustomer(String Cid);

    /**
     * 根据id查询一个用户信息
     * @param Cid
     * @return
     */
    public Customer findCustomerById(String Cid);

    /**
     * 修改用户信息
     * @param customer
     */
    public void updateCustomer(Customer customer);

    /**
     * 批量删除用户
     * @param Cids
     */
    void delSelectedCustomer(String[] Cids);

    /**
     * 分页+条件 查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Customer> findCustomerByPage(String currentPage, String rows, Map<String, String[]> condition);
}