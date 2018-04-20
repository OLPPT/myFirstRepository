package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by OL-PC on 2018/04/18.
 */
@Controller
@RequestMapping("/th")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","你好");
        return "hello";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user(Model model){
        User user = new User();
        user.setAge("哈哈");
        user.setDes("<font color='green'>hello thymeleaf</font>");
        user.setName("哈哈");
        user.setTime(new Date());
        System.out.println(user.getName());
        model.addAttribute("user",user);

        User u1 = new User();
        u1.setName("晓明");
        u1.setTime(new Date());
        u1.setDes("<font color='red'>hello 晓明</font>");
        u1.setAge("12");

        User u2 = new User();
        u2.setName("晓红");
        u2.setTime(new Date());
        u2.setDes("<font color='red'>hello 晓红</font>");
        u2.setAge("11");

        User u3 = new User();
        u3.setName("傅红雪");
        u3.setTime(new Date());
        u3.setDes("<font color='red'>hello 傅红雪</font>");
        u3.setAge("28");
        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        model.addAttribute("userList",userList);
        return "user";
    }
    @RequestMapping("/postform")
    public String postform(User user, RedirectAttributes model){
        System.out.println(user.getName());
        model.addFlashAttribute("name",user.getName());
        return "redirect:result";
    }
    @RequestMapping("/result")
    public String result(){
        return "result";
    }
}
