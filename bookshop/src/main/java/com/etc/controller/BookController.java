package com.etc.controller;

import com.etc.pojo.*;
import com.etc.service.BookService;
import com.etc.service.BookrackService;
import com.etc.service.ChaptersService;
import com.etc.service.SortService;
import com.etc.vo.BookVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hrf
 * 书籍类的控制器
 */

@Controller
public class BookController {

    Logger logger=Logger.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @Autowired
    ChaptersService chaptersService;

    @Autowired
    BookrackService bookrackService;

    @Autowired
    SortService sortService;


    @RequestMapping("/booklist")
    public String booklist(Model model){
        logger.debug("进入了列表控制器");
        List<Book> list1=bookService.findAll();
        /*List<Sort> list3=sortService.findByBook1();*/
        model.addAttribute("list1",list1);
        /*model.addAttribute("list3",list3);*/
        /*List<Sort> type=sortService.findBySortOrder(11);
        List<Sort> list1=sortService.findByBook();
        model.addAttribute("list1",list1);
        model.addAttribute("type",type);*/
        List<Map<String,Object>> list = new ArrayList<>();
        List<Sort> listsort = sortService.findByBook();

        for (Sort s:listsort) {
            List<Sort> list2=sortService.findByParentId(s.getSortId());
            Map<String,Object> map = new HashMap<>();
            map.put("one",s);
            map.put("list2",list2);
            list.add(map);
        }
        model.addAttribute("list",list);
        return "bookmail";
    }


    @RequestMapping("/xiangqing")
    public String xiangqing(int bookId,Model model){
        logger.debug("进入了详情控制器");
        Book book=bookService.findById(bookId);
        List<BookVO> list1=bookService.findList(bookId);
        /*List<Chapters> list1=chaptersService.findByBookId(bookId);*/
        model.addAttribute("book",book);
        model.addAttribute("list1",list1);
        /*model.addAttribute("list1",list1);*/
        return "bookdetails";
    }

    @RequestMapping("/zhangjie")
    public String zhangjie(int bookId,int chaptersId,Model model){
        logger.debug("进入了阅读页面控制器");
        Book book=bookService.findById(bookId);

        Chapters chapters=chaptersService.findByChaptersId(chaptersId);
        model.addAttribute("chapters",chapters);
        model.addAttribute("book",book);
        return "bookread";
    }

    @RequestMapping("/shoucang")
    public String shoucang(int bookId,Model model,HttpSession session){
        logger.debug("进入了书架（收藏）控制器");
        User user=(User) session.getAttribute("currentUser");
        Bookrack bookrack=new Bookrack();
        bookrack.setBookId(bookId);
        int userId = user.getUserId();
        bookrack.setUserId(userId);
        Bookrack bookrack1=bookrackService.find(userId,bookId);
        if(bookrack1==null){
            int i=bookrackService.add(bookrack);
            System.out.println(i);
        }else {
            return "redirect:shoucang1.action";
        }
        Book book1=bookService.findById(bookId);
        List<Bookrack> list2=bookrackService.findAll();
        model.addAttribute("book1",book1);
        model.addAttribute("list2",list2);
        return "redirect:shoucang1.action";
    }


    @RequestMapping("/shoucang1")
    public String shoucang1(HttpSession session,Model model){
        logger.debug("进入了收藏列表控制器");
        /* List<Bookrack> list=bookrackService.findAll();*/
        User user=(User) session.getAttribute("currentUser");
        List<Bookrack> list=bookrackService.findByuserId(user.getUserId());
        model.addAttribute("list",list);
        return "bookshelfdetails";
    }

    @RequestMapping("/delete")
    public String delete(int bookId){
        int i=bookrackService.delete(bookId);
        System.out.println("删除是否成功"+i);
        return "redirect:shoucang1.action";
    }

    @RequestMapping("/qihuan")
    public String qihuan(int sortId,Model model){
        List<Book> book=bookService.findBysortIdTwo(sortId);
        Sort sort=sortService.findBySortId(sortId);
        /*List<Sort> list1=sortService.findByBook();
        List<Book> list=bookService.findAll();*/
        model.addAttribute("book",book);
        model.addAttribute("sort",sort);
        /*model.addAttribute("list1",list1);
        model.addAttribute("list",list);*/
        return "bookmail1";
    }

    @RequestMapping("/type")
    public String type(int sortId,Model model){
        logger.debug("进入了种类控制器");
        List<Book> list1=bookService.findAll();
        List<Sort> list2=sortService.findByParentId(sortId);
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);

        List<Map<String,Object>> list3 = new ArrayList<>();
        List<Sort> listsort = sortService.findByBook();
        for (Sort s:listsort) {
            List<Sort> list4=sortService.findByParentId(s.getSortId());
            Map<String,Object> map = new HashMap<>();
            map.put("one",s);
            map.put("list2",list4);
            list3.add(map);
        }
        model.addAttribute("lis",list3);
        return "bookmail2";
    }

    @RequestMapping("/zhonglei")
    public String zhonglei(int sortId,int sortStats,Model model){
        List<Book> list=bookService.findBysortIdTwo(sortStats);
        Sort sort=sortService.findBySortId(sortId);
        model.addAttribute("list",list);
        model.addAttribute("sort",sort);
        return "bookmail1";
    }

    @RequestMapping("/tooadd")
    public String tooadd(Model model){
        logger.info("进入了去增加的页面的控制器");
        List<Sort> list1 = sortService.findByBook();
        model.addAttribute("list1",list1);
        List<Sort> listsort = sortService.findByBook();
        model.addAttribute("list",listsort);
        return "addbook1";
    }

    @RequestMapping("/add1")
    public String add1(Book book, @RequestParam("file") MultipartFile file, String name){
        logger.info("进入了增加的控制器");
        logger.info(file);
        logger.info(file.getName());
        logger.info(file.getOriginalFilename());
        logger.info(name);

        try {
            //创建硬盘的文件地址
            String path="E:\\hrf\\project\\Workplace4\\java0723-3-group-project-3\\bookshop\\src\\main\\webapp\\statics\\img\\"+file.getOriginalFilename();
            //将内存上的file转换为硬盘上的file
            file.transferTo(new File(path));
            //将原文件的名字添加至作用域中
            /*model.addAttribute("fileName",file.getOriginalFilename());*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        bookService.add(book);
        return "redirect:booklist.action";
    }


    @RequestMapping("/toaddsection")
    public String toadd(int bookId ,Model model){
        Book book = bookService.findById(bookId);
        logger.info("书籍编号："+bookId);
        logger.info("进入去创建章节的处理器");
        model.addAttribute("book",book);
        return "addsection";
    }


    @RequestMapping("/addsection")
    public String addsection(int bookId,Chapters chapters){
        logger.info("bookId"+bookId);
        logger.info("进入创建章节的处理器");
        chapters.setChaptersName(chapters.getChaptersName());
        chapters.setChaptersText(chapters.getChaptersText());
        chapters.setChaptersPrice(chapters.getChaptersPrice());
        chaptersService.add(chapters);
        return "redirect:xiangqing.action?bookId="+bookId;
    }

}
