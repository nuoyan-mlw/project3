package com.crazycode.mapper;

import com.crazycode.pojo.Syslog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LogMapper {
    //查询所有的日志
    public List<Syslog> queryLog()throws Exception;
}
