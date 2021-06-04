package service;
import domain.Doctor;
import domain.PageBean;

import java.util.List;
import java.util.Map;

//用户管理的业务接口
public interface DoctorService {
    /**
     * 分页+条件 查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Doctor> findDoctorByPage(String currentPage, String rows, Map<String, String[]> condition);
}