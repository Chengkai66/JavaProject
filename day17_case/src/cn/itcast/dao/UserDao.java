package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

//用户操作的dao
public interface UserDao {
    public List<User> findAll();
    public User findUsernameAndPassword(String username,String password);
    public void add(User user);

    void delete(int i);

    User findById(int parseInt);

    void update(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    /**
     * 添加时判断用户名是否存在
     * @param username
     * @return
     */
    boolean findByName(String username);

//    /**
//     * 添加时判断用户名是否已经存在
//     * @return
//     */
//    boolean findByName(String check_name);
}
