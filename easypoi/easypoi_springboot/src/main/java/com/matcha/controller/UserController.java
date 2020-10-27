package com.matcha.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.matcha.entity.User;
import com.matcha.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "index";
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
