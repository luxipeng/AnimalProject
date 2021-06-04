package dao;
import domain.Doctor;
import java.util.List;
import java.util.Map;
/**
 * 用户操作的DAO
 */
public interface DoctorDao {
    int findTotalCount(Map<String, String[]> condition);
    /**
     * 分页 +条件 查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Doctor> finByPage(int start, int rows, Map<String, String[]> condition);
}