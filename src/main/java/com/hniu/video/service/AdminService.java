package com.hniu.video.service;

import com.hniu.video.dto.AdminTableDto;
import com.hniu.video.entity.AdminTableEx;

import java.util.List;

/**
 * 管理端service
 *
 * @author 陈威
 */
public interface AdminService {
    /**
     * 添加管理员
     *
     * @param adminTableEx AdminTableEx
     * @return int
     */
    boolean insertAdminTable(AdminTableDto adminTableDto);

    /**
     * 查看所有管理员信息
     *
     * @return list
     */
    List<AdminTableEx> listAdminTable();

    /**
     * 根据id查看管理员信息
     *
     * @param id ID
     * @return int
     */
    AdminTableEx queryAdminTable(int id);

    /**
     * 根据id来修改管理信息
     *
     * @param adminTableEx AdminTableExs
     * @return int
     */
    int updateAdminTable(AdminTableEx adminTableEx);

    /**
     * 根据用户名密码登录
     *
     * @param adminTableEx AdminTableEx
     * @return list
     */
    List<AdminTableEx> login(AdminTableEx adminTableEx);

    /**
     * 根据账号或者手机号码查用此管理员是否存在
     * @param username String
     * @return int
     */
    int queryAdminByUserName(String username);
    /**
     * 根据用户名查询此管理员账号是否存在
     * @param name String
     * @return int
     */
    int queryAdminByName(String name);
    /**
     * 根据账号或者手机号码查用此管理员信息
     * @param username String
     * @return int
     */
    AdminTableEx queryAdminByUserNames(String username);
}
