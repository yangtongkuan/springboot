package com.stu.service.template;

import com.stu.entity.VerifyCodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/5 15:32
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class VerifyMongoTemplateServiceImpl implements IVerifyMongoTemplateService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(VerifyCodeInfo verifyCode) {
        mongoTemplate.save(verifyCode);
    }

    @Override
    public VerifyCodeInfo del(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findAndRemove(query, VerifyCodeInfo.class);
    }

    @Override
    public List<VerifyCodeInfo> findByUsernameAndVerifyType(String username, String verifyType) {
        Query query = new Query(Criteria.where("username").is(username).and("verifyType").is(verifyType));
        return mongoTemplate.find(query, VerifyCodeInfo.class);
    }

    @Override
    public void verify(String username, String verifyType) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username).and("verifyType").is(verifyType).and("verifyState").is(0));
        VerifyCodeInfo code = mongoTemplate.findOne(query, VerifyCodeInfo.class);
        if (code == null) {
            throw new Exception("验证码已经失效");
        }
        Query updateQusery = new Query(Criteria.where("id").is(code.getId()));
        Update update = new Update();
        update.set("verifyState", 1);
        mongoTemplate.upsert(query, update, VerifyCodeInfo.class);
    }

}
