package com.etc.controller;

import com.etc.service.impl.PayServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/22  15:41
 */
@RestController
@RequestMapping(value = "/pay")
@AllArgsConstructor
public class PayController {

    private PayServiceImpl payService;

    /*支付宝接口控制器*/
    @RequestMapping(value = "/confirm",produces = {"text/html;charset=UTF-8"})
    public Object pay(String orderFormName,String orderFormId,String orderPrice ) throws Exception{
        //这个接口其实应该是post方式的，但是我这里图方便，直接以get方式访问，
        //且返回格式是text/html，这样前端页面就能直接显示支付宝返回的html片段
        //真实场景下由post方式请求，返回code、msg、data那种格式的标准结构，让前端拿到data里的
        //html片段之后自行加载

        //由于我这里并没有真正的传参数，所以象征性的new一下，避免空指针
        System.out.println("进入付款界面控制器");
        return payService.pay(orderFormName,orderFormId,orderPrice);
    }
    @PostMapping(value = "/notify")
    public Object notifyAsync(HttpServletRequest request){
        Map map=request.getParameterMap();

        System.out.println(map.toString());
        return "ok";
    }

}
