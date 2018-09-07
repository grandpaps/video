package com.hniu.video.service.impl;

import com.hniu.video.dto.AdminTableDto;
import com.hniu.video.entity.AdminTableEx;
import com.hniu.video.mapper.AdminTableMapper;
import com.hniu.video.service.AdminService;
import com.hniu.video.entity.AdminTableEx;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 管理端service实现类
 *
 * @author 黄鹏
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {


    @Resource
    private AdminTableMapper adminTableMapper;

    @Value("${web.upload-path}")
    private String adImageSavePath;

    @Override
    public boolean insertAdminTable(AdminTableDto adminTableDto) {
        AdminTableEx adminTableEx = new AdminTableEx();
        BeanUtils.copyProperties(adminTableDto, adminTableEx);
        if (adminTableDto.getFile() != null && adminTableDto.getFile().getSize() > 0) {
            //图片名称
            String fileName = System.currentTimeMillis() + "_" + adminTableDto.getFile().getOriginalFilename();
            //给出图片是要存储的路径
            File file = new File(adImageSavePath + fileName);
            //获取文件夹路径
            File fileFolder = new File(adImageSavePath);
            System.out.println(fileFolder+"文件夹路径");
            //判断文件夹是否存在不存在创建，mkdirs多级目录一并创建
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                //transferTo()把图片写入磁盘
                adminTableDto.getFile().transferTo(file);
                adminTableEx.setMobilePhone(adImageSavePath+fileName);
                adminTableMapper.insertAdminTable(adminTableEx);
                return true;
            } catch (IllegalStateException | IOException e) {
                // TODO 需要添加日志
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<AdminTableEx> listAdminTable() {
        return adminTableMapper.listAdminTable();
    }

    @Override
    public AdminTableEx queryAdminTable(int id) {
        return adminTableMapper.queryAdminTable(id);
    }

    @Override
    public int updateAdminTable(AdminTableEx adminTableEx) {

        return adminTableMapper.updateAdminTable(adminTableEx);
    }

    @Override
    public List<AdminTableEx> login(AdminTableEx adminTableEx) {
        return adminTableMapper.login(adminTableEx);
    }

    @Override
    public int queryAdminByUserName(String username) {
        return adminTableMapper.queryAdminByUserName(username);
    }

    @Override
    public int queryAdminByName(String name) {
        return adminTableMapper.queryAdminByName(name);
    }

    @Override
    public AdminTableEx queryAdminByUserNames(String username) {
        return adminTableMapper.queryAdminByUserNames(username);
    }
}
