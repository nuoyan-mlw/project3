package com.crazycode.service.impl;

import com.crazycode.mapper.LogMapper;
import com.crazycode.pojo.Syslog;
import com.crazycode.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Syslog> queryLog() throws Exception {
        return logMapper.queryLog();
    }

    @Override
    public int addLog(Syslog syslog) throws Exception {
        return logMapper.addLog(syslog);
    }
}
