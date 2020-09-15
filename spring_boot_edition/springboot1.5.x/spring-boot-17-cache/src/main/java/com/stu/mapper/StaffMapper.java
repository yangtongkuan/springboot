package com.stu.mapper;

import com.stu.bean.StaffInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/18 12:06
 * @To change this template use File | Settings | File Templates.
 */
public interface StaffMapper {

    @Select("select * from t_staff  where id = #{id}")
    StaffInfo getStaff(Long id);

    @Update("update  t_staff set email = #{email},lastName = #{lastName} where id = #{id}")
    void updateStaff(StaffInfo info);

    @Update("delete  from t_staff where id  = #{id}")
    void delStaff(Long id);

    @Select("select *  from t_staff where lastName  = #{lastName}")
    StaffInfo searchLastName(String lastName);

}
