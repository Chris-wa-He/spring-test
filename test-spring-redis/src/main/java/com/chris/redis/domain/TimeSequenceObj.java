package com.chris.redis.domain;

import java.io.Serializable;
import java.util.Date;

public class TimeSequenceObj implements Serializable {

    private String id;
    private String sequence;
    private Date createdTime;

    public String getId() {
        return id;
    }

    public String getSequence() {
        return sequence;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public TimeSequenceObj() {
        super();
    }

    public TimeSequenceObj(String id, String sequence, Date createdTime) {
        this.id = id;
        this.sequence = sequence;
        this.createdTime = createdTime;
    }
}
