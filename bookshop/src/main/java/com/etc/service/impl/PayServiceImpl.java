package com.etc.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.etc.pojo.OrderForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/22  15:11
 * 支付宝接口实现类
 */
@Service
public class PayServiceImpl {
    @Value("${alipay.returnUrl}")
    private String returnUrl;
    public Object pay(String orderFormName,String orderFormId,String orderPrice) throws Exception{

        AlipayTradePagePayResponse response= Factory.Payment.Page().pay(
            orderFormName,orderFormId,orderPrice,returnUrl
        );
        return response.body;//body是一段html代码
    }
}
