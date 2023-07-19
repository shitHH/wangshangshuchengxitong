package com.etc.controller;

import com.etc.pojo.User;
import com.etc.service.ShoppingService;
import com.etc.vo.ShoppingVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author XS
 * 个人购物车控制器
 */
@Controller
public class ShoopingController {
    Logger logger = Logger.getLogger(ShoopingController.class);

    @Autowired
    ShoppingService shoppingService;
    @RequestMapping("/shoopinglist")
    public String ShoopingList(HttpSession session, Model model){
        Object object = session.getAttribute("currentUser");
        User user = (User)object;
        logger.debug("进入购物车列表控制器");
        List<ShoppingVO> list = shoppingService.findByUserId(user.getUserId());
        for(ShoppingVO shoppingVO:list){
            System.out.println("商品数量"+shoppingVO.getCommodityNumber());
        }
        model.addAttribute("list",list);
        return "shoppingcart";
    }
    @RequestMapping("/deleteshooping")
    public String deleteshooping(int[] arrays) {
        logger.debug("进入购物车删除商品控制器");
        if(arrays.length>0) {
            boolean flag = shoppingService.delete(arrays);
            logger.debug(flag);
        }
        return "redirect:shoopinglist.action";
    }
}
