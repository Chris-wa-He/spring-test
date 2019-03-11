package com.chris.redis.service.impl;

import com.chris.redis.dao.TimeSequenceDao;
import com.chris.redis.domain.TimeSequenceObj;
import com.chris.redis.service.TimeSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TimeSequenceServiceImpl implements TimeSequenceService {

    @Autowired
    private TimeSequenceDao timeSequenceDao;

    @Override
    public void insertObject(Integer volume) {

        TimeSequenceObj timeSequenceObj;

        for (int i = 0; i < volume; i++) {

            timeSequenceObj = new TimeSequenceObj(Integer.toString(i), Integer.toString(i), new Date());

            timeSequenceDao.saveObj(timeSequenceObj);
        }

    }

    @Override
    public void insertStr(Integer volume) {
        for (int i = 0; i < volume; i++) {
            timeSequenceDao.saveStrVal(Integer.toString(i), new Date());
        }
    }
}
