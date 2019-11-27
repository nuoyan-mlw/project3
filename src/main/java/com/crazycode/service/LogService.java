package com.crazycode.service;

import com.crazycode.pojo.Syslog;

import java.util.List;

public interface LogService {

    //查询所有的日志
    public List<Syslog> queryLog()throws Exception;
}
