package com.etc.dao;

import com.etc.pojo.User;
import com.etc.vo.BookCharts;
import com.etc.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ author ls
 * 用户类数据访问接口
 */
public interface UserDao {
    /**
     * 用户注册
     * @param user 用户对象
     */
    public int saveUser(User user);

    /**
     * 登录
     * @param userTel 人员电话
     * @param userPassword 人员密码
     * @return 人员对象
     */
    public User findByTelAndPass(@Param("userTel") String userTel, @Param("userPassword") String userPassword);

    /**
     * 通过用户id查询
     * @param userId
     * @return 用户对象
     */
    public User findByUserId(int userId);

    /**
     * 根据电话查询人员对象
     * @param userTel
     * @return
     */
    public User findByUserTel(String userTel);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    public List<UserVO> findAll();

    /**
     * 注销用户
     * @param userId
     * @return
     */
    public int delete(int userId);
    /**
     * 更新人员
     * @param user 人员对象
     * @return 受影响行数
     */
    public int update(User user);

    /**
     * 查询人员统计
     * @return
     */
    public List<BookCharts> findStat();
}
