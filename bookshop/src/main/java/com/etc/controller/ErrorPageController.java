/*package com.etc.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

*//**
 * @author ls
 * @category
 * 错误页面的控制器
 *//*
@Controller
public class ErrorPageController implements ErrorController {
    Logger logger =Logger.getLogger(ErrorPageController.class);
    public static final String ERROR_PATH ="/error";


    @RequestMapping(ERROR_PATH)
     public String error(){
        logger.info("进入错误页面控制器");
        return "404";
     }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}*/
