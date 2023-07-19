package com.etc.controller;

import com.etc.pojo.*;
import com.etc.service.*;
import com.etc.vo.*;
import org.apache.log4j.Logger;
import org.hibernate.validator.internal.xml.MappingXmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @category: 商品控制器
 * @author: cwsheng
 * @version: 1.0
 * @date: 2021/11/18 15:29
 */
@Controller
public class CommodityController {
    // 创建日志信息
    Logger logger = Logger.getLogger(CommodityController.class);
    // 评论
    @Autowired
    CommentService commentService;
    // 商品
    @Autowired
    CommodityService commodityService;
    // 购物车
    @Autowired
    ShoppingService shoppingService;
    // 分类
    @Autowired
    SortService sortService;
    // 订单
    @Autowired
    OrderFormService orderFormService;
    // 商品，订单关系
    @Autowired
    OrderCommodityService orderCommodityService;

    /**
     * 商品展示控制器
     */
    @RequestMapping("/list")
    public String list(Model model){
        logger.info("进入商品列表控制器");
        List<CommodityVO> list = commodityService.findAll();
        List<Sort> list1 = sortService.findCommodity(1);
        List<Sort> list2 = sortService.findCommodity(2);
        List<Sort> list3 = sortService.findCommodity(3);
        for (Sort sort:list1){
            System.out.println("1级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        for (Sort sort:list2){
            System.out.println("2级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        for (Sort sort:list3){
            System.out.println("3级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list3);
        return "commoditylist";
    }
    /**
     * 一级分类查询展示
     */
    @RequestMapping("/classifyonelist")
    public String classifyOneList(int sortId,Model model,HttpSession session){
        logger.info("进入一级商品分类列表控制器");
        List<CommodityVO> list = commodityService.findBySortIdOne(sortId,1);
        List<Sort> list1 = sortService.findCommodity(1);
        List<Sort> list2 = sortService.findByParentId(sortId);
        /*List<Sort> list3 = sortService.findByParentId(sortId);*/
        List<Map> list4 = new ArrayList<Map>();
        for (Sort sort:list1){
            System.out.println("1级:"+sort.getParentId());
            String sortName = sort.getSortName();
        }
        for (Sort sort:list2){
            System.out.println("2级:"+sort.getParentId());
            String sortName = sort.getSortName();
            int sortIds = sort.getSortId();
            System.out.println("二级id"+sortIds);
            List<Sort> list3 = sortService.findByParentId(sortIds);
            for (Sort sort1:list3){
                System.out.println("3级:"+sort1.getParentId());
                String sortName1= sort1.getSortName();
                System.out.println("3级名称:"+sort1.getSortName());
                Map map = new HashMap();
                map.put("sort1",sort1);
                map.put("sort",sort);
                list4.add(map);
            }
            System.out.println("id"+sortIds);
        }
        for (CommodityVO commodityVO:list){
            System.out.println("商品名"+commodityVO.getCommodityName());
            String commodityName = commodityVO.getCommodityName();
            String commodityPicture = commodityVO.getCommodityPicture();
        }
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list4);
        session.setAttribute("sortOne",sortId);
        return "commodityclassifylist";
    }
    /**
     * 二级分类查询展示
     */
    @RequestMapping("/classifytwolist")
    public String classifyTwoList(int sortId,Model model,HttpSession session){
        logger.info("进入二级商品分类列表控制器");
        Object obj = session.getAttribute("sortOne");
        int sortone = (int) obj;
        System.out.println("session"+sortone);
        List<CommodityVO> list = commodityService.findBySortIdTwo(sortId,1);
        List<Sort> list1 = sortService.findCommodity(1);
        List<Sort> list2 = sortService.findByParentId(sortone);
        List<Sort> list3 = sortService.findByParentId(sortId);
        for(CommodityVO commodityVO:list){
            System.out.println("商品名"+commodityVO.getCommodityName());
            String commodityName = commodityVO.getCommodityName();
            String commodityPicture = commodityVO.getCommodityPicture();
        }
        for (Sort sort:list1){
            System.out.println("1级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        for (Sort sort:list2){
            System.out.println("2级:"+sort.getParentId());
            String sortName = sort.getSortName();
            System.out.println("二级id"+sortId);
        }
        for (Sort sort:list3){
            System.out.println("3级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        for (CommodityVO commodityVO:list){
            System.out.println("商品名"+commodityVO.getCommodityName());
            String commodityName = commodityVO.getCommodityName();
            String commodityPicture = commodityVO.getCommodityPicture();
        }
        session.setAttribute("sortTwo",sortId);
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list3);
        /*return "commodityclassifytwolist";*/
        return "commoditylist";
    }
    /**
     * 三级分类查询展示
     */
    @RequestMapping("/classifythreelist")
    public String classifyThreeList(int sortId,Model model,HttpSession session){
        logger.info("进入三级商品分类列表控制器");
        Object obj = session.getAttribute("sortOne");
        Object obj1 = session.getAttribute("sortTwo");
        int sortone = (int) obj;
        int sorttwo = (int) obj1;
        System.out.println("1级id"+sortone);
        System.out.println("2级id"+sorttwo);
        List<CommodityVO> list = commodityService.findBySortIdThree(sortId,1);
        List<Sort> list1 = sortService.findCommodity(1);
        List<Sort> list2 = sortService.findByParentId(sortone);
        List<Sort> list3 = sortService.findByParentId(sorttwo);
        for (CommodityVO commodityVO:list){
            System.out.println("4级商品:"+commodityVO.getCommodityName());
            String commodityName = commodityVO.getCommodityName();
            String commodityPicture = commodityVO.getCommodityPicture();
        }
        for (Sort sort:list1){
            System.out.println("1级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        for (Sort sort:list2){
            System.out.println("2级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        for (Sort sort:list3){
            System.out.println("3级:"+sort.getSortOrder());
            String sortName = sort.getSortName();
        }
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list3);
        return "commoditylist";
    }
    /**
     * 商品详情控制器
     */
    @RequestMapping("/commodityinfo")
    public String Commoditylist(int commodityId, Model model){
        logger.info("进入商品详情控制器");
        //获得商品详情
        CommodityVO commodityVO = commodityService.findByCommodityId(commodityId);
        model.addAttribute("commodityVO",commodityVO);
        //获得当前商品所有评论
        List<Map<String,Object>> list =new ArrayList<>();
        //获得当前商品评论所有楼层
        List<CommentVO> listComment = commentService.findByCommodity(commodityId);
        //遍历楼层
        if(listComment!=null){
            for (CommentVO c:listComment
            ) {
                //获得当前评论编号，查询楼层回复
                List<CommentVO> listZi = commentService.findByCparentId(c.getCommentId());
                //创建MAP存储
                Map<String,Object> map = new HashMap<>();
                //添加商品回复
                map.put("one",c);
                if (listZi!=null){
                    //添加楼层回复
                    map.put("two",listZi);
                }
                //将map放入list
                list.add(map);
            }
        }
        //将评论集合放入model
        model.addAttribute("list",list);
        return "commodityinfo";
    }
    //添加评论
    @RequestMapping("/addccomment")
    @ResponseBody
    public CommentVO addComment(Comment comment){
        logger.info("进入添加评论控制器");
        boolean flag=commentService.add(comment);
        String ll=flag?"添加成功":"添加失败";
        logger.info(ll);

        CommentVO commentVO = commentService.findByCommentId(comment.getCommentId());
        return commentVO;
    }
    /**
     * 立即借阅控制器
     */
    @RequestMapping("/buy")
    public String buy(int commodityId, Model model,HttpSession session){
        logger.info("进入立即借阅控制器");
        Object obj = session.getAttribute("currentUser");
        User user = (User)obj;
        CommodityVO commodityVO = commodityService.findByCommodityId(commodityId);
        Shopping shopping = new Shopping();
        shopping.setCommodityId(commodityVO.getCommodityId());
        shopping.setUserId(user.getUserId());
        shopping.setCommodityNumber(1);
        // 创建订单
        OrderForm orderForm = new OrderForm();
        orderForm.setOrderPrice(commodityVO.getCommodityPrice());
        orderForm.setUserId(user.getUserId());
        orderForm.setFormStatsId(2);
        orderFormService.add(orderForm);
        logger.info("用户id："+orderForm.getUserId());
        logger.info("金额："+orderForm.getOrderPrice());
        // 创建订单，商品关联信息
        OrderCommodity vo = new OrderCommodity();
        vo.setOrderFormId(orderForm.getOrderFormId());
        System.out.println("商品编号:"+commodityVO.getCommodityId());
        vo.setOrderCommodityNumber(1);
        vo.setCommodityId(commodityVO.getCommodityId());
        boolean flag1 = orderCommodityService.add(vo);
        logger.info("是否添加成功-"+flag1);
        model.addAttribute("orderForm",orderForm);
        return "redirect:toorders.action?orderFormId="+orderForm.getOrderFormId();
    }
    /**
     * 商品添加购物车控制器
     */
    @RequestMapping("/addcommodity")
    public String addCommodity(int commodityId, Model model,HttpSession session){
        logger.info("进入加入购物车控制器");
        Object obj = session.getAttribute("currentUser");
        User user = (User)obj;
        CommodityVO commodityVO = commodityService.findByCommodityId(commodityId);
        Shopping shopping = new Shopping();
        shopping.setCommodityId(commodityVO.getCommodityId());
        shopping.setUserId(user.getUserId());
        shopping.setCommodityNumber(1);
        Boolean flag = shoppingService.add(shopping);
        logger.info(flag);
        // 重定向到商品列表展示
        /*return "redirect:commodityinfo.action?commodityId="+commodityId;*/
        return "redirect:list.action";
    }
    /**
     * 商品结算控制器
     */
    @RequestMapping("/jiesuan")
    public String jieSuan(double OrderPrice, OrderCommodityVO orderCommodityVO, Model model, HttpSession session, HttpServletRequest request){
        logger.info("进入订单结算控制器");
        // 打印信息
        System.out.println("数量"+orderCommodityVO.getOrderCommodityNumber());
        // 获取订单列表
        Object obj = session.getAttribute("currentUser");
        User user = (User)obj;
        // 创建订单
        OrderForm orderForm = new OrderForm();
        orderForm.setOrderPrice(OrderPrice);
        orderForm.setUserId(user.getUserId());
        orderForm.setFormStatsId(2); // 订单状态
        boolean flag = orderFormService.add(orderForm); // 添加订单
        logger.info("用户id："+orderForm.getUserId());
        logger.info("金额："+orderForm.getOrderPrice());
        logger.info(flag);

        // 根据订单编号查询商品集合
        List<ShoppingVO> list = shoppingService.findByUserId(user.getUserId());
        List<Map> list1 = new ArrayList<Map>();
        for(ShoppingVO shoppingVO:list){
            System.out.println("商品数量"+shoppingVO.getCommodityNumber());
            System.out.println("商品编号:"+shoppingVO.getCommodityId());
            //获取页面商品数量及订单金额
            int orderCommodityNumber=Integer.valueOf(request.getParameter("orderCommodityNumber"));
            OrderCommodity vo = new OrderCommodity();
            vo.setOrderFormId(orderForm.getOrderFormId());
            vo.setOrderCommodityNumber(orderCommodityNumber);
            vo.setCommodityId(shoppingVO.getCommodityId());
            boolean flag1 = orderCommodityService.add(vo);
            logger.info("是否添加成功-"+flag1);
        }
        // 储存订单列表
        model.addAttribute("orderForm",orderForm);
        model.addAttribute("list",list);
        // 重定向到下单页面
        return "redirect:toorders.action?orderFormId="+orderForm.getOrderFormId();
    }
}
