package com.example.woc.controller;


import com.example.woc.entity.User;
import com.example.woc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 04:19
 **/

@RequestMapping("/admin")
public class AdminController {


    //请仿照 User 补充 Admin 的三层架构并完成接口
    @Autowired
    private UserService userService;

    /**
     * 获取当前的账户总数
     *
     * @return
     */

    @RequestMapping(value = "/alluser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 根据用户名删除账户
     *
     */
    @GetMapping("delete")
    public void delete(Integer id, RedirectAttributes attributes) {

        boolean b = userService.deleteByName(id);
        if (b) {
            attributes.addFlashAttribute("message", "删除用户成功");

        } else {
            attributes.addFlashAttribute("message", "删除用户失败");
        }
    }
}

