package com.stu.service.template;

import com.stu.entity.VerifyCodeInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/5 15:30
 * @To change this template use File | Settings | File Templates.
 */
public interface IVerifyMongoTemplateService {

    void save(VerifyCodeInfo verifyCode);

    VerifyCodeInfo del(Long id);

    List<VerifyCodeInfo> findByUsernameAndVerifyType(String username, String verifyType);

    void verify(String username, String verifyType) throws Exception;


}
