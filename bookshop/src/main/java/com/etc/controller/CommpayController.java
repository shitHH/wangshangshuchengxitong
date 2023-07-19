package com.etc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @category: 商城帮助控制器
 * @author: cwsheng
 * @version: 1.0
 * @date: 2021/11/21 11:02
 */
@Controller
public class CommpayController {
    Logger logger = Logger.getLogger(CommpayController.class);

    @RequestMapping("/scgmlc")
    public String scgmlc(){
        logger.info("进入商城帮助控制器");
        return "scgmlc";
    }
    @RequestMapping("/cjwt")
    public String cjwt(){
        logger.info("进入商城常见问题控制器");
        return "cjwt";
    }
    @RequestMapping("/zcxy")
    public String zcxy(){
        logger.info("进入商城注册协议控制器");
        return "zcxy";
    }
    @RequestMapping("/zhcz")
    public String zhcz(){
        logger.info("进入商城账户充值控制器");
        return "zhcz";
    }
    @RequestMapping("/zhtx")
    public String zhtx(){
        logger.info("进入商城账户提现控制器");
        return "zhtx";
    }
    @RequestMapping("/zffs")
    public String zffs(){
        logger.info("进入商城支付方式控制器");
        return "zffs";
    }
    @RequestMapping("/friendlink")
    public String friendLink(){
        logger.info("进入商城友情链接控制器");
        return "friendlink";
    }
    @RequestMapping("/ysjrz")
    public String ysjrz(){
        logger.info("进入商城作家入驻控制器");
        return "ysjrz";
    }
    @RequestMapping("/gsjj")
    public String gsjj(){
        logger.info("进入商城公司简介控制器");
        return "gsjj";
    }
    @RequestMapping("/contact")
    public String contact(){
        logger.info("进入商城联系我们控制器");
        return "contact";
    }
    @RequestMapping("/jrwm")
    public String jrwm(){
        logger.info("进入商城加入我们控制器");
        return "jrwm";
    }
    @RequestMapping("/wlsm")
    public String wlsm(){
        logger.info("进入商城物流说明控制器");
        return "wlsm";
    }
    @RequestMapping("/mzsm")
    public String mzsm(){
        logger.info("进入商城负责说明控制器");
        return "mzsm";
    }
    @RequestMapping("/znx")
    public String znx(){
        logger.info("进入站内信控制器");
        return "znx";
    }
    @RequestMapping("/zhye")
    public String zhye(){
        logger.info("进入账户控制器");
        return "zhye";
    }
}
