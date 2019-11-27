package com.crazycode.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//当控制器方法出错的时候的就会交给SysExceptionHandler类来调用带有@ExceptionHandler的方法进行异常处理
public class SysExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex){
        ModelAndView mv = new ModelAndView();
        SysException se=null;
        if(ex instanceof  SysException){
            se = (SysException)ex;
        }else{
            String message = ex.getMessage();
            System.out.println(message);
            se= new SysException(message);
        }
        System.out.println(se.getMessage());
        mv.addObject("errorInfo",se.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
