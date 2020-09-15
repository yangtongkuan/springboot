package com.stu.service.mongo;

import com.stu.dao.UserTokenRepository;
import com.stu.entity.UserTokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserTokenService {

    @Autowired
    private UserTokenRepository userTokenRepository;

    public UserTokenInfo createToken(Long userId) {
        UserTokenInfo info = new UserTokenInfo();
        info.setId(1L);
        info.setCreateTime(new Date());
        info.setDelFlag(0);
        info.setUserId(userId);
        info.setExpireTime(new Date(System.currentTimeMillis() + 15 * 24 * 60 * 60 * 1000L));
        info.setToken(UUID.randomUUID().toString());
        this.remove(userId); // 先删除之前的id 然后存储登录的token信息
        return userTokenRepository.save(info);
    }

    public UserTokenInfo getByToken(String token) {
        return userTokenRepository.findByTokenAndAndDelFlag(token, 0);
    }

    // 假删除  实更新
    public void remove(Long userId) {
        List<UserTokenInfo> userTokenInfos = userTokenRepository.findByUserIdAndDelFlag(userId, 0);
        if (userTokenInfos != null && !userTokenInfos.isEmpty()) {
            userTokenInfos = userTokenInfos.stream().map(b -> b.setDelFlag(1)).collect(Collectors.toList());
            userTokenRepository.save(userTokenInfos);
        }
    }

    //  数据的删除  一般系统不会这麽做 系统中数据往往是一种假的删除
    public void del(Long id) {
        UserTokenInfo info = userTokenRepository.findOne(id);
        if (info != null) {
            userTokenRepository.delete(info);
        }
    }

    public List<UserTokenInfo> listOfUserId(Long userId) {
        return userTokenRepository.findByUserIdAndDelFlag(userId, 0);
    }


}
