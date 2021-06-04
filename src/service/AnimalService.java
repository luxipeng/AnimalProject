package service;
import domain.Animal;
import domain.History;
import domain.PageBean;

import java.util.List;
import java.util.Map;

//用户管理的业务接口
public interface AnimalService {
    /*
    查询所有用户信息
     */
    public List<Animal> findAll();

    /*
    添加用户信息
     */
    public int addAnimal(Animal animal);

    /*
   添加用户信息
    */
    public int addHistory(History history);

    public List<History> findHistory(String pid);

    /*
    根据id删除用户信息
     */
    public void deleteAnimal(String Pid);

    /**
     * 根据id查询一个用户信息
     * @param Pid
     * @return
     */
    public Animal findAnimalById(String Pid);

    /**
     * 修改用户信息
     * @param animal
     */
    public void updateAnimal(Animal animal);

    /**
     * 批量删除用户
     * @param Pids
     */
    void delSelectedAnimal(String[] Pids);

    /**
     * 分页+条件 查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Animal> findAnimalByPage(String currentPage, String rows, Map<String, String[]> condition);
}