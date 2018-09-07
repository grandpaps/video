package com.hniu.video.controller;

import com.hniu.video.dto.AdminTableDto;
import com.hniu.video.entity.AdminTableEx;
import com.hniu.video.service.AdminService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员管理
 *
 * @author 陈威
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminController {
    /**
     * 注入service
     */
    @Resource
    private AdminService adminService;

    @Value("${web.upload-path}")
    private String adImageSavePath;

    /**
     * 查看所有管理员信息
     *
     * @return 页面
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public List<AdminTableEx> list(HttpServletRequest request, ModelMap modelMap) {
        List<AdminTableEx> adminTableExes = adminService.listAdminTable();
        return adminTableExes;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertAdmin(AdminTableDto adminTableDto){
        Map<String,Object> map = new HashMap<>(2);
        boolean b = adminService.insertAdminTable(adminTableDto);
        if(b){
            map.put("msg","添加成功");
            return map;
        }
        else {
            map.put("msg","添加失败");
            return map;
        }
    }


}
