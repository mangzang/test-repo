package com.lagou.controller;


import com.lagou.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

//@Controller
@RestController//来替代@Controller和@ResponseBody(返回响应的值)两个注解
public class ControllerNext {

    @RequestMapping("/ajaxRequest")//映射地址
   // @ResponseBody   //返回响应的值（集合，map，对象，-》进行json序列化，或者字符串-》直接响应输出）
    public List<User> ajaxRequest(@RequestBody List<User> userList){


        System.out.println(userList);

        return userList;

    }

    //{id}表示占位符，需要需要findall方法中的参数名保持一致，这样才能取到这个值
    @RequestMapping(value = "/findAll/{id}",method = RequestMethod.GET)
   // @ResponseBody
    public String findAll(@PathVariable Integer id){

        System.out.println(id);

        return "findAll"+id;

    }


    @DeleteMapping("/deleteById/{id}")//代替下面这标签
    /*@RequestMapping(value = "/deleteById/{id}",method = RequestMethod.POST)*/
    //@ResponseBody
    public String deleteById(@PathVariable Integer id){

        return "post"+id;

    }

    @PutMapping("/put")
    public String put(){

        return put();

    }

    @RequestMapping("/upload")
    //单文件上传
    public String upload(String username, MultipartFile file) throws IOException {
        System.out.println(username);

        String originalFilename = file.getOriginalFilename();

        file.transferTo(new File("E:/"+originalFilename));


        return "success";
    }

    @RequestMapping("/multiUpload")
    //多文件上传
    public String multiUpload(String username, MultipartFile[] file) throws IOException {
        System.out.println(username);

        for (MultipartFile multipartFile : file) {

            String originalFilename = multipartFile.getOriginalFilename();
            System.out.println(originalFilename);
            multipartFile.transferTo(new File("e:/"+originalFilename));
        }

        return "success";
    }



}
