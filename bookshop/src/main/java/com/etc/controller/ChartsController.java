package com.etc.controller;

import com.etc.service.BlogsService;
import com.etc.service.BookService;
import com.etc.service.CommodityService;
import com.etc.service.UserService;
import com.etc.vo.BlogsCharts;
import com.etc.vo.BookCharts;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author zwh
 * @date 2021/11/22
 * 图标展示控制器
 */
@Controller
@RequestMapping("/backstage")
public class ChartsController {
    Logger logger = Logger.getLogger(ChartsController.class);
    @Autowired
    BlogsService blogsService;
    @Autowired
    BookService bookService;
    @Autowired
    CommodityService commodityService;
    @Autowired
    UserService userService;
    //去到博客图表展示控制器
    @RequestMapping("toblogscharts")
    public String toBlogsCharts(){
        logger.info("进入去博客图表展示控制器");
        return "blogsdatastatistics";
    }

    //展示个人说说数量
    @RequestMapping("/chartfirst")
    @ResponseBody
    public List<BlogsCharts> chartFirst(){
        List<BlogsCharts> list = blogsService.findStat();
        return list;
    }

    @RequestMapping("/chartsecode")
    @ResponseBody
    public Map<String,List> chartSecode(){
        Map<String,List> map = blogsService.findStatBar();
        return map;
    }


    //去到书籍图表展示控制器
    @RequestMapping("tobookcharts")
    public String toBookCharts(){
        logger.info("进入去书籍图表展示控制器");
        return "booksdatastatistics";
    }

    //展示书籍类型数量
    @RequestMapping("/chartbookfirst")
    @ResponseBody
    public List<BookCharts> chartBookFirst(){
        List<BookCharts> list = bookService.findStat();
        return list;
    }
    @RequestMapping("/chartbooksecode")
    @ResponseBody
    public Map<String,List> chartBookSecode(){
        Map<String,List> map = bookService.findStatBar();
        return map;
    }

    //去到商品图表展示控制器
    @RequestMapping("tocommoditycharts")
    public String toCommodityCharts(){
        logger.info("进入去书籍图表展示控制器");
        return "commoditydatastatistics";
    }

    //展示书籍类型数量
    @RequestMapping("/chartcommodityfirst")
    @ResponseBody
    public List<BookCharts> chartCommodityFirst(){
        List<BookCharts> list = commodityService.findStat();
        return list;
    }
    @RequestMapping("/chartcommoditysecode")
    @ResponseBody
    public Map<String,List> chartCommoditySecode(){
        Map<String,List> map = commodityService.findStatBar();
        return map;
    }

    //去到商品图表展示控制器
    @RequestMapping("tousercharts")
    public String toUserCharts(){
        logger.info("进入去书籍图表展示控制器");
        return "userdatastatistics";
    }

    //展示书籍类型数量
    @RequestMapping("/chartuserfirst")
    @ResponseBody
    public List<BookCharts> chartUserFirst(){
        List<BookCharts> list = userService.findStat();
        return list;
    }
    @RequestMapping("/chartusersecode")
    @ResponseBody
    public Map<String,List> chartUserSecode(){
        Map<String,List> map = userService.findStatBar();
        return map;
    }

}
