package com.matcha.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.matcha.entity.Card;
import com.matcha.entity.Emp;
import com.matcha.entity.Order;
import com.matcha.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/25 21:11
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
public class TestEasyPoi {

    private List<Order> getOrderList() {
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Order order = new Order();
            order.setName("超短裙" + i);
            order.setNo("py" + i);
            orders.add(order);
        }
        return orders;
    }

    private List<User> getUserList() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i))
                    .setAge(i)
                    .setName("matcha_" + i)
                    .setBir(new Date());
            user.setStatus(i % 2);
            if (0 == i % 2) {
                user.setPhoto("C:\\Users\\Administrator\\Desktop\\util\\1.jpg");
            }
            Card card = new Card(String.valueOf(i), "身份证信息card很长" + i);
            user.setCard(card);
            user.setOrders(getOrderList());
            list.add(user);
        }
        return list;
    }

    @Test
    public void testExport() {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, getUserList());
        try {
            FileOutputStream outputStream = new FileOutputStream("F:\\aa.xls");
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testImport() {

        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(1); // 标题列占用几行
            params.setHeadRows(2); // header列占几行
            params.setStartSheetIndex(0); // 设置从哪个开始读取
            params.setImportFields(new String[]{"编号", "状态"}); // 检测excel模板中是否有此字段
            List<Emp> list = ExcelImportUtil.importExcel(new FileInputStream("F:\\aa.xls"), Emp.class, params);
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
