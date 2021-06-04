package dao;

import domain.Customer;
import domain.Doctor;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface CustomerDao {
    public List<Customer> findAll();

    Doctor findDoctorByUsernameAndPassword(String number, String password);

    public void addCustomer(Customer customer);

    public int deleteCustomer(String Cid);

    public Customer findCustomerById(String Cid);

    public void updateCustomer(Customer customer);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页 +条件 查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Customer> finByPage(int start, int rows, Map<String, String[]> condition);
}
