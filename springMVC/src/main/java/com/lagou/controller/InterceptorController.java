package com.lagou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    @RequestMapping("/testI")
    public String testI(){

        System.out.println("方法执行中");
        return "success";
    }

}
