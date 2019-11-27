package com.crazycode.web.controller;

import com.crazycode.pojo.Syslog;
import com.crazycode.service.LogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SyslogController {
    @Autowired
    private LogService logService;

    @GetMapping("/log/queryLog")
    public ModelAndView queryLog()throws Exception{
        ModelAndView mv = new ModelAndView("pages/syslog-list");
        List<Syslog> logList = logService.queryLog();
        mv.addObject("logList",logList);
        return mv;
    }
}
