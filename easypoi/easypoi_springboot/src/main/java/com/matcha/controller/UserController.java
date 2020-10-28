package com.matcha.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.matcha.entity.User;
import com.matcha.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/26 22:40
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${upload.dir}")
    private String uploadPath;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "index";
    }


    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        // 查询
        List<User> users = userService.findAll();
        users.forEach(item -> {
            item.setPhoto(uploadPath + File.separator + item.getPhoto());
        });
        log.info("导出Excel,当前数据库中数据总数为: [{}]", users.size());
        try {
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode("用户列表.xls", "UTF-8"));
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户列表信息", "用户列表"), User.class, users);
            ServletOutputStream stream = response.getOutputStream();
            workbook.write(stream);
            stream.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/import")
    public String importExcel(MultipartFile excelFile) throws Exception {
        log.info("文件名:{}", excelFile.getOriginalFilename());
        ImportParams params = new ImportParams();
        params.setTitleRows(1); // 设置标题行数
        params.setHeadRows(1); // 设置字符行数
        List<User> users = ExcelImportUtil.importExcel(excelFile.getInputStream(), User.class, params);
//        users.forEach(System.out::println);
        userService.saveList(users);
        return "redirect:/user/findAll";
    }
}
