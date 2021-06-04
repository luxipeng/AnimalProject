package dao.impl;
import dao.CustomerDao;
import domain.Customer;
import domain.Doctor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerDaoImpl implements CustomerDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Customer> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql="select *from customer";
        //         如果调用的方法是一个多结果集的，返回一个list集合。如果是一个单结果集的，就会返回一个对象
        List<Customer> customers = template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
        return customers;
    }

    public Doctor findDoctorByUsernameAndPassword(String number, String password){
        try {
            String sql="select *from doctor where number=? and password=?";
            Doctor doctor = template.queryForObject(sql, new BeanPropertyRowMapper<Doctor>(Doctor.class), number, password);
            return doctor;
        }catch (Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            String sql="insert into customer values(?,?,?,?,?,?,?)";
            template.update(sql,customer.getCid(),customer.getName(),customer.getGender(),customer.getAge(),customer.getAddress(),customer.getCity(),customer.getPhone());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int deleteCustomer(String Cid) {
        try{
            String sql="delete from customer where cid =?";
            //执行sql语句
            template.update(sql,Cid);
            int a=1;
            return a;
        }catch (Exception e){
            System.out.println("该主人仍然有正在医治的宠物！");
            int a=2;
            e.printStackTrace();
            return a;
        }
    }

    @Override
    public Customer findCustomerById(String Cid) {
        String sql="select *from customer where cid=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Customer>(Customer.class),Cid);
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql="update customer set name=?,gender=?,age=?,address=?,city=?,phone=? where cid=?";
        template.update(sql,customer.getName(),customer.getGender(),customer.getAge(),customer.getAddress(),customer.getCity(),customer.getPhone(),customer.getCid());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql="select count(*) from customer where 1 =1 ";
        StringBuilder sb=new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;  //结束当前的循环，继续下一次循环
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)){
                //有值
                sb.append("and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值  模糊查询，不能只传value，还要加上%
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        //return template.queryForObject(sb.toString(),Integer.class,params.toArray());//结果集的封装,自动拆箱变为int
        Integer integer = template.queryForObject(sb.toString(), Integer.class, params.toArray());
        return integer;
    }

    @Override
    public List<Customer> finByPage(int start, int rows, Map<String, String[]> condition) {
//        String sql="select *from user limit ? , ?";
        String sql="select *from customer where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数 (否则会把它俩传递到sql语句中)
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;  //结束当前的循环，继续下一次循环
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append("and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值  模糊查询，不能只传value，还要加上%
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql=sb.toString(); //一定要转化成String类型，才能执行template的查询方法
        System.out.println(sql);
        System.out.println(params);
        //return template.query(sql,new BeanPropertyRowMapper<Customer>(Customer.class),params.toArray());
        List<Customer> query = template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class), params.toArray());
        return query;
    }
}