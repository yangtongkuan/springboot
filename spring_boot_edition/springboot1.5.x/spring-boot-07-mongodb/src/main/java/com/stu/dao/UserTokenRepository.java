package com.stu.dao;

import com.stu.entity.UserTokenInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserTokenRepository extends MongoRepository<UserTokenInfo, Long> {

    UserTokenInfo findByTokenAndAndDelFlag(String token, int delFlag);

    List<UserTokenInfo> findByUserIdAndDelFlag(Long userId, int delFlag);

}
