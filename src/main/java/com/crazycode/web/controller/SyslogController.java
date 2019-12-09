package com.crazycode.web.controller;

import com.crazycode.pojo.Syslog;
import com.crazycode.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SyslogController {
    @Autowired
    private LogService logService;

    @GetMapping("/log/queryLog.do/{pageNo}/{pageSize}")
    public ModelAndView queryLog(@PathVariable("pageNo") String pageNo,@PathVariable("pageSize") String pageSize)throws Exception{
            ModelAndView mv = new ModelAndView("pages/syslog-list");
            PageHelper.startPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
            List<Syslog> logList = logService.queryLog();
            PageInfo pageInfo = new PageInfo(logList);
            mv.addObject("data",pageInfo);
            return mv;
    }
}
