package com.etc.dao;

import com.etc.pojo.Role;

import java.util.List;

/**
 * 角色类数据访问接口
 */
public interface RoleDao {
    /**
     * 查询所有的角色
     * @return 角色集合
     */
    public List<Role> findAll();

    /**
     * 添加角色
     * @param role 角色对象
     * @return 受影响的行数
     */
    public int add(Role role);

    /**
     * 删除角色
     * @param roleId 角色编号
     * @return 受影响的行数
     */
    public int delete(int roleId);


    /**
     * 查找角色对象
     * @param roleId 角色对象的编号
     * @return 角色对象
     */
    public Role findById(int roleId);

    /**
     * 更新角色对象
     * @param role 角色对象
     * @return 受影响的行数
     */
    public int updateRole(Role role);

}
