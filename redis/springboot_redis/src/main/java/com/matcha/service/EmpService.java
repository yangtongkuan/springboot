package com.matcha.service;

import com.matcha.entity.EmpEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/19 22:06
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
public interface EmpService {

    EmpEntity findById(String id);

    void update(EmpEntity emp);

}
