package service.impl;
import dao.AnimalDao;
import dao.impl.AnimalDaoImpl;
import domain.Animal;
import domain.History;
import domain.PageBean;
import service.AnimalService;

import java.util.List;
import java.util.Map;

public class AnimalServiceImpl implements AnimalService {
    private AnimalDao dao=new AnimalDaoImpl();
    @Override
    public List<Animal> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public int addAnimal(Animal animal) {
        return dao.addAnimal(animal);
    }

    @Override
    public int addHistory(History history) {
        return dao.addHistory(history);
    }

    public List<History> findHistory(String pid){
        return dao.findHistory(pid);
    }

    @Override
    public void deleteAnimal(String Pid) {
        dao.deleteAnimal(Pid);
    }

    @Override
    public Animal findAnimalById(String Pid) {
        Animal animal=dao.findAnimalById(Pid);
        return animal;
    }

    @Override
    public void updateAnimal(Animal animal) {
        dao.updateAnimal(animal);
    }

    @Override
    public void delSelectedAnimal(String[] Pids) {
        //不仅要在前台判断是否勾选了，在后台也要判断
        //防止出现空指针异常
        if (Pids!=null && Pids.length>0){
            //1.遍历数组
            for (String Pid : Pids) {
                //2.调用dao删除
                dao.deleteAnimal(Pid);
            }
        }
    }

    @Override
    public PageBean<Animal> findAnimalByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
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
        PageBean<Animal> pb=new PageBean<Animal>();

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
        List<Animal> list=dao.finByPage(start,rows,condition);
        pb.setList(list);

        //5.计算总页码
       // int totalPage=(totalCount % rows)==0 ? (totalCount / rows) : (totalCount / rows +1);
        pb.setTotalPage(totalPage);

        //6.返回PageBean对象
        return pb;
    }
}