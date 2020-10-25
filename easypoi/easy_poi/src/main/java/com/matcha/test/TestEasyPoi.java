package com.matcha.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.matcha.entity.Card;
import com.matcha.entity.Order;
import com.matcha.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
}
