package com.stu.dao;

import com.stu.entity.Person;
import com.stu.entity.Sex;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.apache.tomcat.util.descriptor.web.NamingResources;

/**
 * @desc 使用 mapper 动态sql 语句来执行sql
 */
public class PersonMapperProvider {

    // 插入一条信息信息
    public String getInsertSql(Person person) {
        return new SQL() {
            {
                INSERT_INTO("t_person");
                if (person.getName() != null && person.getName() != "") {
                    VALUES("name", "#{name}");
                }
                if (person.getLastName() != null && person.getLastName() != "") {
                    VALUES("last_name", "#{lastName}");
                }
                if (person.getAge() != null && person.getAge() > 0) {
                    VALUES("age", "#{age}");
                }
                if (person.getSex() != null && (person.getSex().equals(Sex.MAN) || person.getSex().equals(Sex.WOMAN))) {
                    VALUES("sex", "#{sex}");
                }
            }
        }.toString();
    }

    // 删除一个sql
    public String getDelSql(Long id) {
        return new SQL() {
            {
                DELETE_FROM("t_person");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 修改信息
    public String getUpdateOneSql(Person p) {
        return new SQL() {
            {
                UPDATE("t_person");
                SET("name=#{name}");
                if (p.getAge() != null && p.getAge() > 0) {
                    SET("age = #{age}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 查询
    public String getSelectSql(@Param("name") String name, @Param("age") Integer age) {
        return new SQL() {
            {
                SELECT("id,name,last_name as lastName,age,sex");
                FROM("t_person");
//                if (map.get("name") != null && map.get("name") != "") {
//                    WHERE("name like CONCAT('%',#{name},'%')");
//                }
//                if (map.get("age") != null && Integer.parseInt(map.get("age").toString()) > 0) {
//                    WHERE("age > #{age}");
//                }
                if (name != null && name != "") {
                    WHERE("name like CONCAT('%',#{name},'%')");
                }
                if (age != null && age > 0) {
                    WHERE("age > #{age}");
                }
            }
        }.toString();
    }


}
