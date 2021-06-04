package dao;

import domain.Animal;
import domain.History;

import java.util.List;
import java.util.Map;

public interface AnimalDao {
    /**
     * 用户操作的DAO
     */
        public List<Animal> findAll();

        public int addAnimal(Animal animal);

        public int addHistory(History history);

        public List<History> findHistory(String pid);

        public void deleteAnimal(String Pid);

        public Animal findAnimalById(String Pid);

        public void updateAnimal(Animal animal);

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
        List<Animal> finByPage(int start, int rows, Map<String, String[]> condition);
    }
