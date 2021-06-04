package dao.impl;
import dao.AnimalDao;
import domain.Animal;
import domain.History;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnimalDaoImpl implements AnimalDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Animal> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql="select *from animal";
        //         如果调用的方法是一个多结果集的，返回一个list集合。如果是一个单结果集的，就会返回一个对象
        List<Animal> animals = template.query(sql, new BeanPropertyRowMapper<Animal>(Animal.class));
        return animals;
    }

    @Override
    public List<History> findHistory(String pid) {
        //使用JDBC操作数据库
        //1.定义sql
        String sql="select *from history where pid =?";
        //         如果调用的方法是一个多结果集的，返回一个list集合。如果是一个单结果集的，就会返回一个对象
        List<History> histories = template.query(sql, new BeanPropertyRowMapper<History>(History.class),pid);
        return histories;
    }

    @Override
    public int addAnimal(Animal animal) {
        try {
            String sql="insert into animal values(?,?,?,?,?)";
            template.update(sql,animal.getPid(),animal.getName(),animal.getKind(),animal.getBirth(),animal.getOwner());
            int a=1;
            return a;
        }catch (Exception e){
            System.out.println("添加失败！！！");
            e.printStackTrace();
            int b=2;
            return b;
        }
    }

    @Override
    public int addHistory(History history) {
        try {
            String sql="insert into history values(?,?,?)";
            template.update(sql,history.getPid(),history.getData(),history.getDescribe());
            int a=1;
            return a;
        }catch (Exception e){
            System.out.println("添加失败！！！");
            e.printStackTrace();
            int b=2;
            return b;
        }
    }

    @Override
    public void deleteAnimal(String Pid) {
        try{
            String sql="delete from animal where pid =?";
            //执行sql语句
            template.update(sql,Pid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Animal findAnimalById(String Pid) {
        String sql="select *from animal where pid=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Animal>(Animal.class),Pid);
    }

    @Override
    public void updateAnimal(Animal animal) {
        String sql="update animal set name=?,kind=?,birth=?,owner=? where pid=?";
        template.update(sql,animal.getName(),animal.getKind(),animal.getBirth(),animal.getOwner(),animal.getPid());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql="select count(*) from animal where 1 =1 ";
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
    public List<Animal> finByPage(int start, int rows, Map<String, String[]> condition) {
//        String sql="select *from user limit ? , ?";
        String sql="select *from animal where 1=1 ";
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
        return template.query(sql,new BeanPropertyRowMapper<Animal>(Animal.class),params.toArray());
    }
}