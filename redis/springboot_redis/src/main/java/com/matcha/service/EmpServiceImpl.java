package com.matcha.service;

import com.matcha.dao.EmpDAO;
import com.matcha.entity.EmpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/19 22:07
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDAO empDAO;

    @Override
    public EmpEntity findById(String id) {
        return empDAO.findById(id);
    }

    @Override
    public void update(EmpEntity emp) {
        empDAO.update(emp);
    }
}
