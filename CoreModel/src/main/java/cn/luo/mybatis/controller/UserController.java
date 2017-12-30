package cn.luo.mybatis.controller;

import cn.luo.mybatis.service.UserService;
import cn.luo.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public String getUserList(Model model){
        List<User> list = userService.getUserList();
        model.addAttribute("list",list);
        return "showUsers";
    }

}
