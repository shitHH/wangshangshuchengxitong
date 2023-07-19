package com.etc.controller;

import com.etc.pojo.*;
import com.etc.service.*;
import com.etc.vo.OrderCommodityVO;
import com.etc.vo.OrderFormVO;
import com.etc.vo.ShoppingVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/19  10:01
 * 订单表控制器
 */
@Controller
public class OrderFormController {
    //创建日志信息
    Logger logger=Logger.getLogger(OrderFormController.class);

    @Autowired
    OrderFormService orderFormService;

    @Autowired
    OrderCommodityService orderCommodityService;

    @Autowired
    ProvinceCityAreaService pcaService;
    @Autowired
    UserService userService;
    @Autowired
    ShoppingService shoppingService;
    @RequestMapping("/backstage/orderformlist")
    public String orderformlist(Model model){
        logger.info("进入了订单列表控制器");
        List<OrderFormVO> list=orderFormService.findAll();

        model.addAttribute("list",list);
        logger.info(list);
        return "orderreview";
    }

    @RequestMapping("/userorderformlist")
    public String userorderformlist(HttpSession session, Model model){
        Object object = session.getAttribute("currentUser");
        User user = (User)object;
        logger.info("进入到用户订单列表控制器");
        List<Map> maps=new ArrayList<Map>();
        //通过用户id获取我的订单
        List<OrderFormVO> list=orderFormService.findByUserId(user.getUserId());
        logger.info(list.size());
        if (list!=null){
            /*遍历我的订单*/
            for (OrderFormVO oFVO : list) {
                /*获取我的订单编号*/
                int orderFormId=oFVO.getOrderFormId();

                logger.info(orderFormId);
                //获取订单关系表vo集合
                List<OrderCommodityVO> list1=orderCommodityService.findByorderFormId(orderFormId);

                Map map=new HashMap();
                map.put("oFVO",oFVO);
                map.put("list1",list1);
                maps.add(map);
            }
        }
        /*将Map集合放进作用域中*/
        model.addAttribute("maps",maps);
        return "personnelorder";
    }
    //下单页面
    @RequestMapping("/toorders")
    public String toorders(int orderFormId,Model model){
        logger.info("进入到下单页面控制器");
        /*通过订单编号获取商品订单vo*/
        List<OrderCommodityVO> list=orderCommodityService.findByorderFormId(orderFormId);
        /*通过订单编号获取订单信息*/
        OrderForm orderFormVO=orderFormService.findById(orderFormId);
        logger.info(orderFormVO.getUserId());
        //通过订单编号获取用户信息
        User user=userService.findByUserId(orderFormVO.getUserId());
        logger.info(user.getUserName());

        /*将所得信息放进作用域中*/
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        model.addAttribute("orderFormVO",orderFormVO);
        return "orders";
    }
//    /*去修改收货信息控制器*/
//    @RequestMapping("/toeditorder")
//    public String toeditorder(int orderFormId,Model model){
//        logger.info("进入到去修改收货地址控制器");
//        OrderForm orderForm=orderFormService.findById(orderFormId);
//        model.addAttribute("orderForm",orderForm);
//        return "editorder1";
//    }
    /*#修改收货地址*/
    @RequestMapping("/editorder")
    public String editorder(HttpServletRequest request,int orderFormId) throws InterruptedException{
        logger.info("进入修改收货地址控制器");
        /*创建订单对象*/
        OrderForm orderForm=orderFormService.findById(orderFormId);
        /*接受省市区信息*/
        String provinceID=request.getParameter("province");
        logger.info(provinceID);
        String cityID=request.getParameter("city");
        String areaID=request.getParameter("area");
        /*通过省市区id查找省市区名称*/
        Province province=pcaService.findByprovinceID(provinceID);
        logger.info(province);
        City city=pcaService.findBycityID(cityID);
        Area area=pcaService.findByareaID(areaID);
        //获取详细地址
        String address=request.getParameter("test1");
        logger.info(address);
        //将省市区，详细地址拼接起来放入订单对象
        String client=province.getProvince()+city.getCity()+area.getAreas()+address;
        logger.info(client);
        orderForm.setClientSite(client);
        orderFormService.update(orderForm);
        return "redirect:/toorders.action?orderFormId="+orderFormId;
    }
    //进入去付款页面控制器
    @RequestMapping("/topayment")
    public String topayment(Model model,int orderFormId){
        logger.info("进入去付款界面控制器");
        //获取订单关系表vo集合
        List<OrderCommodityVO> list=orderCommodityService.findByorderFormId(orderFormId);
        /*通过订单编号获取订单信息*/
        OrderForm orderForm=orderFormService.findById(orderFormId);
        logger.info(orderForm.getUserId());
        //通过订单编号获取用户信息
        User user=userService.findByUserId(orderForm.getUserId());
        /*将所得信息放进作用域中*/
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        model.addAttribute("orderForm",orderForm);
        return "payment";
    }
    //交易成功
    @RequestMapping("/zhifucheng")
    public String zhifucheng(HttpSession session){
        System.out.println("进入了支付成功控制器");
        Object object = session.getAttribute("currentUser");
        User user = (User)object;
        List<ShoppingVO> list=shoppingService.findByUserId(user.getUserId());
        int[] array=new int[10];
        int i=0;
        for (ShoppingVO shoppingVO : list) {
            array[i]=shoppingVO.getShoppingId();
            i++;
        }
        boolean flag= shoppingService.delete(array);
        return "zhifuchenggong";
    }
    //订单详情控制器
    @RequestMapping("toorderinfopayment")
    public String toorderinfopayment(int orderFormId,Model model){
        logger.info("进入个人订单详情控制器");
        /*通过订单编号获取订单信息*/
        OrderForm orderForm=orderFormService.findById(orderFormId);
        //通过订单编号获取用户信息
        User user=userService.findByUserId(orderForm.getUserId());
        //获取订单关系表vo集合
        List<OrderCommodityVO> list=orderCommodityService.findByorderFormId(orderFormId);
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        model.addAttribute("orderForm",orderForm);
        return "orderinfopayment";
    }
    @RequestMapping("/findallprovinces")
    @ResponseBody
    public List<Province> findAllProvinces(){
        logger.info("查询省的处理器");
        List<Province> list = pcaService.findAllProvince();
        return list;
    }

    @RequestMapping("/findcity")
    @ResponseBody
    public List<City> findCity(String provinceID){
        logger.info("查询市的处理器");
        List<City> list = pcaService.findAllCityByProvinceID(provinceID);
        return list;
    }

    @RequestMapping("/findarea")
    @ResponseBody
    public List<Area> findArea(String cityID){
        logger.info("查询区县的处理器");
        List<Area> list = pcaService.findAllAreaByCityID(cityID);
        return list;
    }

}
