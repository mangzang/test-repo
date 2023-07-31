package com.lagou.controller;

import com.lagou.domain.CommixUser;
import com.lagou.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//生成对象放入MVC容器中
@Controller
//指定一级访问目录
@RequestMapping("/user")
@SessionAttributes("username")
public class UserController {


    @RequestMapping(value = "pojoParam",method = RequestMethod.POST)
    public String pojoParam(User user){

        System.out.println(user);
        return "success";
    }


    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id,String username){

        System.out.println(id);
        System.out.println(username);
        return "success";
    }

    //指定二级访问目录，指定触发该方法的请求类型为get，params表示必须要有携带参数
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"accountName"})
    public String quick(){

        //业务逻辑
        System.out.println("springMVC入门");

        //视图跳转，逻辑视图名
        return "success";
    }

    @RequestMapping("/quick2")
    public String quick2(){

        //业务逻辑
        System.out.println("a");

        //视图跳转，逻辑视图名
        return "a";

    }


    @RequestMapping("servletAPI")
    public String servletAPI(HttpServletRequest servletRequest, HttpServletResponse servletResponse, HttpSession session){

        System.out.println(servletRequest);
        System.out.println(servletResponse);
        System.out.println(session);

        return "success";

    }
    //数组类型参数的值注入，保持名子一致
    @RequestMapping(value = "arrays")
    public String arrays(Integer[] ids){

        System.out.println(Arrays.toString(ids));
        return "success";
    }

    @RequestMapping("commix")
    public String commix(CommixUser commixUser){

        System.out.println(commixUser);
        return "success";

    }


    @RequestMapping("birthday")
    public String birthday(String  s){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date parse = null;
        try {
            parse = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
        return "success";

    }

    @RequestMapping("test")
    public String test(Date birthday){


        System.out.println(birthday);
        return "success";


    }

    @RequestMapping("notSame")
    //@RequestParam() 注解
    //defaultValue 设置参数默认值
    //name 匹配页面传递参数的名称
    //required 设置是否必须传递参数，默认值为true；如果设置了默认值，值自动改为false
    public String notSame(@RequestParam(name = "page",defaultValue = "1",required = true)  Integer id){

        System.out.println(id);
        return "success";

    }

    //@RequestHeader("cookie")注入cookie的值给参数cookie1
    @RequestMapping("requestHead")
    public String requestHead(@RequestHeader("cookie") String cookie1){

        System.out.println(cookie1);
        return "success";

    }
    @RequestMapping("cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String cookie){

        System.out.println(cookie);
        return "success";

    }


    @RequestMapping("/requestVoid")
    public void requestVoid(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println("你好");

        //一次请求，作用范围request域，响应的数据只在这一次请求中有效，在二次请求中无效
        request.setAttribute("username","交易");

        //字符串"/WEB-INF/pages/success.jsp"，中头有‘/’开始，表示从相对于当前 Web 应用程序的根目录（WEB-INF），
        // 可以直接从 Web 应用程序的根目录开始直接访问资源。
        //如果没有‘/’，表示向上一级目录寻找 success.jsp 文件。此时如果有一级目录会报错
      // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);




        //重定向是二次请求，对于一次请求的域的内容是找不到/二次请求即是外部请求，所有url会发生改变
         //报错：）model.addAttribute("username1","二次请求");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    @RequestMapping("test1")
    public String test1(Model model){

        Model model1 = model.addAttribute("username", "教育");
        return "forward:/WEB-INF/pages/success.jsp";

    }

    @RequestMapping("forward")
    public String forward(Model model){

        model.addAttribute("username","你好啊");

        return "forward:/WEB-INF/pages/success.jsp";


    }

    @RequestMapping("redirect")
    public String redirect(Model model){

        //model中加入属性值，同时类目处指定属性名放入session域中
        model.addAttribute("username","你好啊");
        return "redirect:/index.jsp";
    }

    //modelAndView进行视图跳转
    @RequestMapping("modelAndView")
    public ModelAndView modelAndView(ModelAndView modelAndView){

        modelAndView.addObject("username1","kkkkkk");
        modelAndView.setViewName("success");
        return modelAndView;
    }


    //测试异常跳转
    @RequestMapping("/testE")
    public String testE(){

        int i=1/0;
        return "success";
    }

}
