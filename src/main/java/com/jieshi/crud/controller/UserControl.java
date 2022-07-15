package com.jieshi.crud.controller;

import com.jieshi.crud.pojo.User;
import com.jieshi.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UserControl {
    @Autowired
    private UserService userService;

    @GetMapping("/index.html")
    public String userList(Map<String, List> result) {
        List<User> users = userService.findAll();
        result.put("users", users);
        return "index";
    }

    /**
     * 新增数据
     */
    @PostMapping("/add")
    public String save(User user) {
        userService.save(user);
        //表示重置index.html界面并且跳转到index.html界面
        return "redirect:/index.html";
    }

    /**
     * 删除数据,本来需要使用DeleteMapping，但是由于没有界面可以隐藏，所以这里就直接写了RequestMapping
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpServletResponse servletResponse) throws IOException {
        userService.delete(id);
        System.out.println("-----delete方法执行-----");
        return "redirect:/index.html";
    }


    /**
     * 根据id进行修改
     */
    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model,@PathVariable int id){
        User user = userService.get(id);
        model.addAttribute("user",user);
        //表示跳转到modify.html界面
        return "modify";
    }

    @PutMapping("/update")
    public String updateUser(Model model, User user, HttpServletRequest request) {
        String id = request.getParameter("id");
        User userById = userService.get(Integer.parseInt(id));
        userService.updateById(user);
        System.out.println(user);
        return "redirect:/index.html";
    }

}
