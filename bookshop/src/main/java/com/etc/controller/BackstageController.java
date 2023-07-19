package com.etc.controller;

import com.etc.pojo.Book;
import com.etc.pojo.Chapters;
import com.etc.pojo.Commodity;
import com.etc.pojo.Sort;
import com.etc.service.*;
import com.etc.vo.BlogsVO;
import com.etc.vo.CommodityVO;
import com.etc.vo.UserVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwh
 * @date 2021/11/18
 * 后台管理控制器
 */
@Controller
@RequestMapping("/backstage")
public class BackstageController {
    Logger logger = Logger.getLogger(BackstageController.class);
    @Autowired
    SortService sortService;
    @Autowired
    BlogsService blogsService;
    @Autowired
    UserService userService;
    @Autowired
    CommodityService commodityService;
    @Autowired
    BookService bookService;
    @Autowired
    ChaptersService chaptersService;


    //跳转后台主页面控制器
    @RequestMapping("/main")
    public String toMain(){
        logger.info("进入跳转后台主页面控制器");
        return "/main";
    }
    //跳转商品类型列表
    @RequestMapping("/tocommoditysortlist")
    public String toCommoditySortList(Model model){
        logger.info("进入跳转商品类型控制器");
        //创建List<Map>
        List<Map<String,Sort>> list = new ArrayList<>();
        //获得商品一级目录
        List<Sort> listCommodityOne = sortService.findByCommodity();
        //遍历商品一级目录
        if(listCommodityOne!=null){
            for (Sort one:listCommodityOne
            ) {
                //获得一级目录类型编号
                int parentIdOne = one.getSortId();
                //获得商品二级目录
                List<Sort> listCommodityTwo = sortService.findByParentId(parentIdOne);
                //遍历二级目录
                if(listCommodityTwo!=null){
                    for (Sort two:listCommodityTwo
                    ) {
                        //获得二级目录编号
                        int parentIdTwo = two.getSortId();
                        //获得商品三级目录
                        List<Sort> listCommodityThree = sortService.findByParentId(parentIdTwo);
                        //遍历三级目录
                        if (listCommodityThree!=null){
                            for (Sort three:listCommodityThree
                                 ) {
                                //创建map添加到将三级目录添加
                                Map<String,Sort> map = new HashMap<>();
                                map.put("one",one);
                                map.put("two",two);
                                map.put("three",three);
                                //将map放入list
                                list.add(map);
                            }
                        }
                    }
                }
            }
        }
        //将list放入model
        model.addAttribute("list",list);
        return "/commoditysortlist";
    }
    //跳转二级商品类型列表
    @RequestMapping("/tocommoditysortlisttwo")
    public String toCommoditySortListTwo(Model model){
        logger.info("进入跳转二级商品类型控制器");
        //创建List<Map>
        List<Map<String,Sort>> list = new ArrayList<>();
        //获得商品一级目录
        List<Sort> listCommodityOne = sortService.findByCommodity();
        //遍历商品一级目录
        if(listCommodityOne!=null){
            for (Sort one:listCommodityOne
            ) {
                //获得一级目录类型编号
                int parentIdOne = one.getSortId();
                //获得商品二级目录
                List<Sort> listCommodityTwo = sortService.findByParentId(parentIdOne);
                //遍历二级目录
                if(listCommodityTwo!=null){
                    for (Sort two:listCommodityTwo
                    ) {
                        //创建map添加到将二级目录添加
                        Map<String,Sort> map = new HashMap<>();
                        map.put("one",one);
                        map.put("two",two);
                        //将map放入list
                        list.add(map);
                    }
                }
            }
        }
        //将list放入model
        model.addAttribute("list",list);
        return "/commoditysortlisttwo";
    }
    //跳转一级级商品类型列表
    @RequestMapping("/tocommoditysortlistone")
    public String toCommoditySortListOne(Model model){
        logger.info("进入跳转一级商品类型控制器");
        //获得商品一级目录
        List<Sort> list = sortService.findByCommodity();
        //将list放入model
        model.addAttribute("list",list);
        return "/commoditysortlistone";
    }
    //跳转到添加一级商品类型控制器
    @RequestMapping("toaddcommoditysort")
    public String toAddCommoditysort(){
        logger.info("进入添加一级商品类型控制器");
        return "/addcommoditysort";
    }
    //跳转到添加二级商品类型控制器
    @RequestMapping("toaddcommoditysorttwo")
    public String toAddCommoditysortTwo(Model model){
        logger.info("进入添加二级商品类型控制器");
        List<Sort> list = sortService.findByCommodity();
        model.addAttribute("list",list);
        return "/addcommoditysorttwo";
    }
    //跳转到添加三级商品类型控制器
    @RequestMapping("toaddcommoditysortthree")
    public String toAddCommoditysortThree(Model model){
        logger.info("进入添加三级商品类型控制器");
        List<Sort> list = sortService.findByCommodity();
        model.addAttribute("list",list);
        return "/addcommoditysortthree";
    }
    //添加类型控制器
    @RequestMapping("addcommoditysort")
    public String addCommoditySort(Sort sort){
        logger.info("进入添加商品类型控制器");
        boolean flag=sortService.add(sort);
        logger.info(flag?"添加成功":"添加失败");
        if(sort.getSortType()==2){
            return "redirect:/backstage/tocommoditysortlist";
        }else {
            return "redirect:/backstage/tobooksortlist";
        }

    }
    //根据父节点查询
    @RequestMapping("/sortparentid")
    @ResponseBody
    public List<Map<String,Object>> sortParentId(int parentId){
        logger.info("进入AJAX控制器");
        List<Map<String,Object>> list = new ArrayList<>();
        List<Sort> list1 = sortService.findByParentId(parentId);
        if (list1!=null){
            for (Sort s:list1
                 ) {
                Map<String,Object> map = new HashMap<>();
                map.put("id",s.getSortId());
                map.put("name",s.getSortName());
                list.add(map);
            }
        }
        return list;
    }
    //跳转书籍类型列表
    @RequestMapping("/tobooksortlist")
    public String toBookSortListTwo(Model model){
        logger.info("进入跳转书籍类型控制器");
        //创建List<Map>
        List<Map<String,Sort>> list = new ArrayList<>();
        //获得商品一级目录
        List<Sort> listCommodityOne = sortService.findByBook();
        //遍历商品一级目录
        if(listCommodityOne!=null){
            for (Sort one:listCommodityOne
            ) {
                //获得一级目录类型编号
                int parentIdOne = one.getSortId();
                //获得商品二级目录
                List<Sort> listCommodityTwo = sortService.findByParentId(parentIdOne);
                //遍历二级目录
                if(listCommodityTwo!=null){
                    for (Sort two:listCommodityTwo
                    ) {
                        //创建map添加到将二级目录添加
                        Map<String,Sort> map = new HashMap<>();
                        map.put("one",one);
                        map.put("two",two);
                        //将map放入list
                        list.add(map);
                    }
                }
            }
        }
        //将list放入model
        model.addAttribute("list",list);
        return "/booksortlist";
    }

    //跳转一级级商品类型列表
    @RequestMapping("/tobooksortlistone")
    public String tobookSortListOne(Model model){
        logger.info("进入跳转一级书籍类型控制器");
        //获得商品一级目录
        List<Sort> list = sortService.findByBook();
        //将list放入model
        model.addAttribute("list",list);
        return "/booksortlistone";
    }

    //跳转到添加一级书籍类型控制器
    @RequestMapping("toaddbooksort")
    public String toAddBooksort(){
        logger.info("进入添加一级书籍类型控制器");
        return "/addbooksort";
    }

    //跳转到添加二级商品类型控制器
    @RequestMapping("toaddbooksorttwo")
    public String toAddBooksortTwo(Model model){
        logger.info("进入添加二级商品类型控制器");
        List<Sort> list = sortService.findByBook();
        model.addAttribute("list",list);
        return "/addbooksorttwo";
    }

    //去到帖子展示所有帖子列表
    @RequestMapping("tobackstageblogslist")
    public String toBackstageBlogsList(Model model){
        logger.info("进入去到博客列表控制器");
        List<BlogsVO> list =  blogsService.findAll();
        logger.info(list.get(0).getBlogsCtime());
        //将list放入model
        model.addAttribute("list",list);
        return "backstageblogslist";
    }


    //去到人员展示列表控制器
    @RequestMapping("userlist")
    public String userlist(Model model){
        logger.debug("进入人员列表控制器");
        List<UserVO> list = userService.findAll();
        model.addAttribute("list",list);
        return "userlist";
    }
    //商品展示列表控制器
    @RequestMapping("commodity")
    public String commodity(Model model){
        logger.debug("进入商品列表控制器");
        List<CommodityVO> list = commodityService.findAll();
        model.addAttribute("list",list);
        return "commodity";
    }
    //商品上架控制器
    @RequestMapping("toaddcommodity")
    public String toaddcommodity(Model model){
        logger.debug("进入添加商品控制器");
        //查询商品一级目录
        List<Sort> list = sortService.findByCommodity();
        model.addAttribute("list",list);
        return "/addcommodity";
    }
    //商品上架控制器
    @RequestMapping("addcommodity")
    public String addcommodity(Commodity commodity,Model model){
        logger.debug("进入添加商品控制器");
        commodity.setCompanyStats(1);
        boolean flag = commodityService.add(commodity);
        return "redirect:/backstage/commodity";
    }
    //去上传图片
    @GetMapping("addfile")
    public String file(int commodityId,Model model){
        logger.debug("进入去添加图片控制器");
        model.addAttribute("commodity",commodityId);
        return "file";
    }
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, String name, Model model,int commodityId){
        logger.info("进入上传商品图片控制器");
        logger.info("commodityId"+commodityId);
        Commodity commodity  =new Commodity();
        commodity.setCommodityId(commodityId);
        // 添加图片功能
        String filename = file.getOriginalFilename();
        logger.info(file);
        logger.info(file.getName());
        logger.info(file.getOriginalFilename());
        logger.info(name);
        logger.info(commodity.getCommodityPicture()+"\t"+commodity.getCommodityId());
        try {
            //创建硬盘的文件地址
            String path = "E:\\zwh\\project\\workspace4\\java0723-3-group-project-3\\bookshop\\src\\main\\webapp\\statics\\pictures"+file.getOriginalFilename();
            //将内存中的file转换为硬盘上的file
            file.transferTo(new File(path));
            //将文件的原名称，添加至作用域中
            model.addAttribute("fileName",file.getOriginalFilename());
        }catch (IOException e){
            e.printStackTrace();
        }
        commodity.setCommodityPicture(filename);
        commodityService.update(commodity);
        model.addAttribute("commodity",commodity);
        return "redirect:/backstage/commodity";
    }
    //修改商品信息控制器
    @RequestMapping("toupdatecommodity")
    public String toupdatecommodity(int commodityId,Model model){
        logger.debug("进入去修改商品信息控制器");
        CommodityVO commodity= commodityService.findByCommodityId(commodityId);
        model.addAttribute("commodity",commodity);
        return "updatecommodity";
    }
    @RequestMapping("updatecommodity")
    public  String updatecommodity(Commodity commodity){
        logger.debug("进入修改商品信息控制器");
        System.out.println(" 押金："+commodity.getCommodityPrice());
        boolean flag = commodityService.update(commodity);
        logger.debug(flag);
        return "redirect:/backstage/commodity";
    }
    @RequestMapping("/deletecommodity")
    public String deletecommodity(int commodityId){
        logger.debug("进入下架商品控制器");
        Commodity commodity = new Commodity();
        commodity.setCommodityId(commodityId);
        commodity.setCompanyStats(2);
        boolean flag= commodityService.update(commodity);
        return "redirect:/backstage/commodity";
    }
    @RequestMapping("booklist")
    public String booklist(Model model){
        logger.debug("进入书籍列表控制器");
        List<Book> list=bookService.findAll();
        model.addAttribute("list",list);
        return "booklist";
    }
    //书籍上架控制器
    @RequestMapping("toaddbook")
    public String toaddbook(Model model){
        logger.debug("进入添加书籍控制器");
        //查询商品一级目录
        List<Sort> list = sortService.findByBook();
        model.addAttribute("list",list);
        return "addbook";
    }
    //书籍上架控制器
    @RequestMapping("addbook")
    public String addbook(Book bookId,Model model){
        logger.debug("进入添加书籍控制器");
        int i = bookService.add(bookId);
        return "redirect:/backstage/booklist";
    }
    @RequestMapping("toaddchapters")
    public String toaddchapters(Model model){
        logger.debug("进入添加章节控制器");
        //查询商品一级目录
        List<Sort> list = sortService.findByBook();
        model.addAttribute("list",list);
        return "/addchapters";
    }
    //书籍上架控制器
    @RequestMapping("addchapters")
    public String addchapters(Book bookId,Model model){
        logger.debug("进入添加章节控制器");
        int i = bookService.add(bookId);
        return "redirect:/backstage/booklist";
    }
    //下架书籍
    @RequestMapping("/deletebook")
    public String deletebook(int bookId){
        logger.debug("进入下架书籍控制器");
        Book book = new Book();
        book.setBookId(bookId);
        book.setBookStats(4);
        int i= bookService.delete(bookId);
        return "redirect:/backstage/booklist";
    }
    //去上传图片
    @GetMapping("toaddfile")
    public String addfile(int bookId,Model model){
        logger.debug("进入去添加图片控制器");
        logger.info("bookId"+bookId);
        model.addAttribute("book",bookId);
        return "addfile";
    }
    @RequestMapping("/toupload")
    public String toupload(@RequestParam("file") MultipartFile file, String name, Model model,int bookId){
        logger.info(file);
        logger.info(file.getName());
        logger.info(file.getOriginalFilename());
        logger.info(name);
        String fileName = file.getOriginalFilename();
        try {
            //创建硬盘的文件地址
            String path = "E:\\zwh\\project\\workspace4\\java0723-3-group-project-3\\bookshop\\src\\main\\webapp\\statics\\pictures"+file.getOriginalFilename();
            //将内存中的file转换为硬盘上的file
            file.transferTo(new File(path));
            //将文件的原名称，添加至作用域中
            model.addAttribute("fileName",file.getOriginalFilename());
        }catch (IOException e){
            e.printStackTrace();
        }
        Book book = new Book();
        book.setBookId(bookId);
        book.setPhoto(fileName);
        bookService.update(book);
        model.addAttribute("book",book);
        return "redirect:/backstage/booklist";
    }
    //展示商品详情控制器
    @RequestMapping("commoditydetails")
    public String commoditydetails(int commodityId,Model model){
        logger.debug("进入展示商品详情控制器");
        CommodityVO commodity = commodityService.findByCommodityId(commodityId);
        model.addAttribute("commodity",commodity);
        return "commoditydetails";
    }
    //展示书籍详情控制器
    @RequestMapping("htbookdetails")
    public String htbookdetails(int bookId,Model model){
        logger.debug("进入展示书籍详情控制器");
        Book book = bookService.findById(bookId);
        model.addAttribute("book",book);
        return "houtaikookdetails";
    }
    //展示章节详情控制器
    @RequestMapping("chapterdetails")
    public String chapterdetails(int chaptersId,Model model){
      Chapters chapter= chaptersService.findByChaptersId(chaptersId);
       model.addAttribute("chapter",chapter);
        return "chapterdetails";
    }
}
