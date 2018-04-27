package org.cheng.mapper;

import org.cheng.pojo.SysUser;

import java.util.List;

/**
 * @author cheng
 *         2018/4/27 13:55
 */
public interface SysUserMapperCustom {

    /**
     * 查询简单用户信息
     *
     * @param id
     * @return
     */
    List<SysUser> queryUserSimplyInfoById(String id);
}
