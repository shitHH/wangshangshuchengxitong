package com.etc.controller;

import com.etc.pojo.Blogs;
import com.etc.pojo.Comment;
import com.etc.pojo.User;
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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XS
 * 个人博客列表控制器
 */
@Controller
public class BlogsController {
    Logger logger = Logger.getLogger(BlogsController.class);
    @Autowired
    BlogsService blogsService;
    @Autowired
    CommentService commentService;


    @RequestMapping("/postlist")
    public String Postlist(HttpSession session, Model model){
        logger.debug("进入个人博客列表展示控制器");
        Object object =  session.getAttribute("currentUser");
        if(object != null){
            User user=(User) object;

            List<BlogsVO> list = blogsService.findByUserId(user.getUserId());
            model.addAttribute("list",list);
            return "/postlist";
        }
        return "404";


    }

    @RequestMapping("allpostlist")
    public String allpostlist(Model model){
        logger.debug("进入所有帖子展示");
       List<BlogsVO> list = blogsService.findAll();
       model.addAttribute("list",list);
        return "allpostlist";
    }
    @RequestMapping("/toaddpost")
    public String toadd(){
     logger.debug("进入去添加博客控制器");
     return "/addpost";
    }
    @RequestMapping("addpost")
    public String addpost(Blogs blogs){

        logger.debug("进入添加个人博客控制器");
        logger.info(blogs.getUserId());
        logger.info(blogs.getBlogsText());

        boolean flag = blogsService.add(blogs);
        logger.debug(flag);

        return "redirect:/postlist";
    }
    @RequestMapping("/postdetails")
    public  String postdetails(int blogsId,Model model){
        logger.debug("进入展示帖子详情控制器");
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

    @RequestMapping("deletepost")
    public String deletepost(int[] arrays){
        logger.debug("进入删除帖子控制器");
        logger.info(arrays);
        if (arrays.length>0){
        boolean flag = blogsService.delete(arrays);
        logger.debug(flag);
        }
        return "redirect:postlist.action";
    }





    /*@RequestMapping("/comment")
    public String comment(int blogsId,Model model){
        logger.debug("进入评论列表控制器");
       List<CommentVO> list= commentService.findByBlogs(blogsId);
       model.addAttribute("list",list);
       return "postdetails";
    }
    @RequestMapping("addcomment")
    public  String addcomment(Comment comment,Model model){
        logger.debug("进入添加评论控制器");
       boolean flag =  commentService.add(comment);
         logger.debug(flag);
        return "postdetails";
    }*/



}
