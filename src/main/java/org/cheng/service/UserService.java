package org.cheng.service;

import org.cheng.pojo.SysUser;

import java.util.List;

/**
 * @author cheng
 *         2018/4/27 12:41
 */
public interface UserService {

    /**
     * 保存用户信息
     *
     * @param user
     * @throws Exception
     */
    void saveUser(SysUser user) throws Exception;

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(SysUser user);

    /**
     * 删除用户信息
     *
     * @param user
     */
    void deleteUser(SysUser user);

    /**
     * 根据 id 查询用户信息
     *
     * @param userId
     * @return
     */
    SysUser queryUserById(String userId);


    /**
     * 根据查询条件查询用户列表
     *
     * @param user
     * @return
     */
    List<SysUser> queryUserList(SysUser user);

    /**
     * 根据查询条件分页查询用户列表
     *
     * @param user
     * @param page
     * @param pageSize
     * @return
     */
    List<SysUser> queryUserListPaged(SysUser user, Integer page, int pageSize);

    /**
     * 根据 id 查询普通用户信息
     * @param userId
     * @return
     */
    SysUser queryUserByIdCustom(String userId);

    /**
     * 事务测试
     * @param user
     */
    void saveUserTransaction(SysUser user);
}
