package com.etc.controller;

import com.etc.pojo.Mtype;
import com.etc.pojo.User;
import com.etc.service.BookService;
import com.etc.service.MtypeService;
import com.etc.service.UserService;
import com.etc.tools.Captcha;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etc.tools.codes;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @category: 人员控制器
 * @author: cwsheng
 * @version: 1.0
 * @date: 2021/11/18 14:36
 */
@Controller
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    MtypeService mtypeService;
    @Autowired
    BookService bookService;
    @RequestMapping({"/","/index"})
    public String index(){
        return "forward:/index.jsp";
    }
    @RequestMapping("/captcaha")
    public void captcaha(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");
            HttpSession session = request.getSession();
            OutputStream os = response.getOutputStream();
            // 返回验证码和图片的map
            Map<String, Object> map = Captcha.getImageCode(86, 37, os);
            String simpleCaptcha = "simpleCaptcha";
            session.setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
            session.setAttribute("codeTime", new Date().getTime());
            ImageIO.write((BufferedImage) map.get("image"), "jpg", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/tologin")
    public String tologin() {
        logger.info("进入去登录控制器");
        return "login";
    }
    @RequestMapping("/login")
    public String login(User user, String captcha, Model model, HttpSession session){
        String currentcaptcha =session.getAttribute("simpleCaptcha").toString();
        if (captcha.equals(currentcaptcha)){
            User currentUser = userService.findByTelAndPass(user.getUserTel(),user.getUserPassword());

            logger.error(currentUser);
            if (currentUser!=null){
                session.setAttribute("currentUser",currentUser);
                System.out.println("进入登录后页面控制器");
                return "redirect:/index.action";
            }else{
                logger.info("进入空值跳转部分");
                model.addAttribute("message","用户账号或密码错误");
                return "login";
            }
        }else{
            model.addAttribute("message","用户验证码输入错误");
            return "login";
        }
    }
  /*  @RequestMapping("/tousermian")
    public String usermain(){
        logger.info("进入到用户登录后的页面的控制器");
        return "usermain";
    }*/
    @RequestMapping("/toadd")
    public String toadd(){
        logger.info("进入了去添加控制器");
        return "register";
    }
    @RequestMapping("/adduser")
    public String add(/*@RequestParam("file") MultipartFile file, */User user ){
        logger.info("进入了注册控制器");
        /*// 添加图片功能
        String filename = file.getOriginalFilename();
        //创建硬盘的文件地址
        String path = "D:\\study\\workspace-springboot\\java0723-3-group-project-3\\bookshop\\src\\main\\webapp\\statics\\pictures\\"+file.getOriginalFilename();
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setUserPhoto(filename);*/

        logger.info(user.getUserIdNumber());
        //从身份中信息中截取生日信息
        int year = Integer.valueOf(user.getUserIdNumber().substring(6,10));
        logger.info(year);
        int month=Integer.valueOf(user.getUserIdNumber().substring(10, 12))-1;
        logger.info(month);
        int day=Integer.valueOf(user.getUserIdNumber().substring(12, 14));
        logger.info(day);
        int sexNum=Integer.valueOf(user.getUserIdNumber().substring(16, 17));
        logger.info(sexNum);

        //根据身份证获得性别
        char userSex=' ';
        if(sexNum%2==0){
            userSex='女';
        }else{
            userSex='男';
        }
        //获得当前时间
        Calendar date=Calendar.getInstance();
        //获得年龄
        int userAge = date.get(Calendar.YEAR)-year;
        //根据身份证获得生日
        date.set(year, month, day);
        Date userBirthday=date.getTime();
        user.setUserSex(userSex);
        user.setUserAge(userAge);
        user.setUserBirthday(userBirthday);
        // 设定注册时默认头像（后期可自行更改）
        user.setUserPhoto("touxiang3.jpg");
        String pro = codes.getDomicile(user.getUserIdNumber());
        logger.info(pro);
        user.setUserCity(codes.getDomicile(user.getUserIdNumber()));

        boolean flag = userService.saveUser(user);
        logger.info(flag);
        return "login";
    }

    @RequestMapping("/toahthenticateduser")
    public String toahthenticateduser(){
        logger.info("进入======控制器");
        return "usertest";
    }

    @RequestMapping("/ahthenticateduser")
    public String ahthenticateduser(User user ,HttpServletRequest request){
        logger.info("进入验证控制器");
        String userTel = user.getUserTel();
        logger.info(userTel);
        String userName = user.getUserName();
        logger.info(userName);
        String userIdNumber = user.getUserIdNumber();
        logger.info(userIdNumber);
        boolean flag =  userService.usertest(userTel,userName,userIdNumber);
        logger.info(flag);
        if (flag){
            User u= userService.findByUserTel(userTel);
            int userId= u.getUserId();
            request.setAttribute("userId",userId);
            return "usereditpass";

        }else{
            request.setAttribute("mes","您输入的信息有误，请重新输入！！！");
        }
        return "usertest";
    }

    @RequestMapping("/usereditpass")
    public String usereditpass(int userId,String ctuserPassword){
        logger.info("进入====修改密码控制器");
        User user = userService.findByUserId(userId);
        logger.info(user);
        user.setUserPassword(ctuserPassword);
        userService.update(user);
        return "login";
    }

    @RequestMapping("/topersonalinfo")
    public String personalinfo(HttpSession session,Model model){
        logger.info("进入我的信息页面。。。");
        Object session1 = session.getAttribute("currentUser");
        User user = (User)session1;
        model.addAttribute("currentUser",user);
        return "personnelinfo";
    }

 /*   @RequestMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, String name, Model model) {
        try {
            //创建硬盘文件路径
            String path = "D:\\dir\\" + file.getOriginalFilename();
            //将内存文件转到硬盘
            file.transferTo(new File(path));
            model.addAttribute("fileName", file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "personnelinfo";
    }*/
  /*  @RequestMapping("/personalinfo")
    public String personal(int userId,Model model){
        logger.info("进入个人信息展示页面");
       User user = userService.findByUserId(userId);
       model.addAttribute("user",user);
       return "editpersonalinfo";
    }*/
    @RequestMapping("/tosignedauthor")
    public String editinfo(HttpSession session, Model model) {
        logger.info("进入成为作者的处理器");
        Object obj = session.getAttribute("currentUser");
        User user = (User) obj;
        model.addAttribute("currentUser",user);
       return "singleauthor";
    }
    @RequestMapping("/signedauthor")
    public String signedauthor(User user){
        logger.info("进入到。。。。。");
        user.setRoleId(2);
        userService.update(user);
        return "redirect:/booklist.action";
    }
    @RequestMapping("/tomember")
    public String tomember(Model model){
        logger.info("去充值页面处理器");
        List<Mtype> list = mtypeService.findAll();
        model.addAttribute("list",list);
        return "membergrade";
    }
    @RequestMapping("/member")
    public String member(HttpSession session){
        logger.info("成为会员");
        Object obj = session.getAttribute("currentUser");
        User u = (User)obj;
        int userId = u.getUserId();
        logger.info(userId);
        User newUser= new User();
        newUser.setUserId(userId);
        newUser.setMemberStats(1);
        userService.update(newUser);
        User user = userService.findByUserId(newUser.getUserId());
        logger.info(user);
        session.setAttribute("currentUser",user);
        return "redirect:/index.action";
    }
    @RequestMapping("/exit")

    public String exit(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/checktel")
    @ResponseBody
    public String checkTel(String userTel){
        logger.info("进入验证的处理器");
        User user =  userService.findByUserTel(userTel);
        if (user!=null){
            return "notok";
        }else{
            return "ok";
        }

    }
    @RequestMapping("/toupdate")
    public String toUpdate(HttpSession session,Model model){
       User user =(User) session.getAttribute("currentUser");
       model.addAttribute("currentUser",user);
       return "editinfo";
    }

    @RequestMapping("/updateinfo")
    public String updateinfo(@RequestParam("file") MultipartFile file,HttpSession session,User user){
        logger.info("修改信息");
        // 添加图片功能
        String filename = file.getOriginalFilename();
        //创建硬盘的文件地址
        String path = "D:\\study\\workspace-springboot\\java0723-3-group-project-3\\bookshop\\src\\main\\webapp\\statics\\pictures\\"+file.getOriginalFilename();
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setUserPhoto(filename);
        user.setUserId(user.getUserId());
        user.setUserEmail(user.getUserEmail());
       //user.setUserPhoto(user.getUserPhoto());
        userService.update(user);
        User user1 = userService.findByUserId(user.getUserId());
        logger.info(user);
        session.setAttribute("currentUser",user1);
        return "redirect:/topersonalinfo.action";
    }
}
