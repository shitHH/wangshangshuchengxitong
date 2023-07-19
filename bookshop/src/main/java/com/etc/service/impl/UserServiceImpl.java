package com.etc.service.impl;


import com.etc.dao.UserDao;
import com.etc.pojo.User;
import com.etc.service.UserService;
import com.etc.tools.MD5Util;
import com.etc.vo.BookCharts;
import com.etc.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ls
 * @category 人员业务逻辑实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Override
    public boolean saveUser(User user) {
        user.setUserPassword(MD5Util.md5(user.getUserPassword()));
        user.setMemberStats(0);
        user.setRoleId(1);
        return userDao.saveUser(user)>0?true:false;
    }

    @Override
    public User findByTelAndPass(String userTel, String userPassword) {
        String password = MD5Util.md5(userPassword);
        return userDao.findByTelAndPass(userTel,password);
    }

    @Override
    public User findByUserId(int userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public User findByUserTel(String userTel) {
        return userDao.findByUserTel(userTel);
    }

    @Override
    public List<UserVO> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean delete(int userId) {
        return userDao.delete(userId)>0?true:false;
    }

    @Override
    public boolean usertest(String userTel, String userName, String userIdNumber) {
        boolean flag = false;
        //通过电话查询
        System.out.println(userTel);
        User user = userDao.findByUserTel(userTel);
        System.out.println(user);
        //判断姓名是否一致
        if (user.getUserName().equals(userName)){
            //判断输入的身份证是否一致
            if (user.getUserIdNumber().equals(userIdNumber)){
                //身份验证成功
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean update(User user) {
        user.setUserPassword(MD5Util.md5(user.getUserPassword()));
        return userDao.update(user)>0?true:false;
    }

    @Override
    public List<BookCharts> findStat() {
        return userDao.findStat();
    }

    @Override
    public Map<String, List> findStatBar() {
        Map<String, List> map = new HashMap<>();
        List<String> names = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<BookCharts> list=userDao.findStat();
        for (BookCharts b:list
        ) {
            names.add(b.getName());
            values.add(b.getValue());
        }
        map.put("names",names);
        map.put("values",values);

        return map;
    }
}
