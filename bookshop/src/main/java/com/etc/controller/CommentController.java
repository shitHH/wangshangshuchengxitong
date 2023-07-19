package com.etc.controller;

import com.etc.service.BlogsService;
import com.etc.service.CommentService;
import com.etc.vo.BlogsVO;
import com.etc.vo.CommentVO;
import com.etc.vo.CommodityVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwh
 * @date 2021/11/23
 */
@Controller
public class CommentController {
    Logger logger = Logger.getLogger(BlogsController.class);
    @Autowired
    BlogsService blogsService;
    @Autowired
    CommentService commentService;
    /**
     * 帖子详情控制器
     */
    @RequestMapping("/postinfo")
    public String Commoditylist(int blogsId,Model model){
        logger.info("进入商品详情控制器");
        //获得商品详情
        BlogsVO blogsVO = blogsService.findByBolgdId(blogsId);
        model.addAttribute("blogs",blogsVO);
        //获得当前商品所有评论
        List<Map<String,Object>> list =new ArrayList<>();
        //获得当前商品评论所有楼层
        List<CommentVO> listComment = commentService.findByBlogs(blogsId);
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
        return "blogsinfo";
    }
}
