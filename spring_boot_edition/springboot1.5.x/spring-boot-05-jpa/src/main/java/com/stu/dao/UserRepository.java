package com.stu.dao;

import ch.qos.logback.classic.util.LoggerNameUtil;
import com.stu.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.function.LongToIntFunction;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 18:19
 * @Classname: UserRepository
 * @To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo getUserInfoById(Long id);

    // 使用hql 方式查询  也支持原始的sql查询  使用hql查询时 使用的是表对应的model 而不是表
    @Query(value = "FROM UserInfo u WHERE u.name like %?1% ")
    List<UserInfo> findByName(String name, Pageable request);

    Page<UserInfo> findByNameLike(String name, Pageable request);

    @Query(value = "select u FROM UserInfo u WHERE u.name like %?1% ",
            countQuery = "SELECT count(u) FROM UserInfo u WHERE u.name like %?1% ",
            nativeQuery = false
    )
    Page<UserInfo> findByNameLikeHql(String name,Pageable request);
    // 方式1
    //    @Modifying
//    @Query(value = " delete from UserInfo  where id = ?1")
//    void deleteById(Long id);
    // 方式2
    void deleteById(Long id);
}
