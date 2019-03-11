package com.chris.redis.dao;

import com.chris.redis.domain.TimeSequenceObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class TimeSequenceDao {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valOpsStr;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOps;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");

    @Async("myTaskAsyncPool")
    public void saveStrVal(String id, Date date) {
        logger.info("Processing obj:" + id);
        valOpsStr.set(id, simpleDateFormat.format(date));
    }

    @Async("myTaskAsyncPool")
    public void saveObj(TimeSequenceObj obj) {
        logger.info("Processing obj:" + obj.getId() + " Content:" + obj.toString());
        valOps.set(obj.getId(), obj);
    }
}
