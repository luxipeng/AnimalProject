package dao.impl;
import dao.AnimalDao;
import dao.DoctorDao;
import domain.Animal;
import domain.Doctor;
import domain.History;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DoctorDaoImpl implements DoctorDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql="select count(*) from doctor where 1 =1 ";
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
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());//结果集的封装,自动拆箱变为int
    }

    @Override
    public List<Doctor> finByPage(int start, int rows, Map<String, String[]> condition) {
//        String sql="select *from user limit ? , ?";
        String sql="select *from doctor where 1=1 ";
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
        return template.query(sql,new BeanPropertyRowMapper<Doctor>(Doctor.class),params.toArray());
    }
}