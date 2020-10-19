package com.matcha.dao;

import com.matcha.entity.EmpEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/19 22:06
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Mapper
public interface EmpDAO {

    EmpEntity findById(String id);

    void update(EmpEntity emp);
}
