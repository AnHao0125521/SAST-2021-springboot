package com.example.woc.service;

import com.example.woc.entity.User;
import com.example.woc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class UserService {

        //该注解可以对类成员变量、方法以及构造函数进行标注，完成自动装配工作
        final
        UserMapper userMapper;

        public UserService(UserMapper userMapper) {
            this.userMapper = userMapper;
        }

        public String login(User user){
            //登录逻辑函数
            try{
                User userExistN = userMapper.findByName(user.getUsername());
                if(userExistN!=null){
                    String userExistP = userMapper.findPswByName(user.getUsername());
                    if(userExistP.equals(user.getPassword())){
                        return user.getUsername()+"登录成功，欢迎您!";
                    }else {
                        return "登录失败，密码错误!";
                    }
                }else {
                    return "登录失败，用户不存在!";
                }
            }catch (Exception e){
                e.printStackTrace();
                return e.getMessage();
            }
        }

        public String regist(User user){
            //注册逻辑函数
            try {
                User userExist = userMapper.findByName(user.getUsername());
                if (user.getUsername().equals("")){
                    return "用户名不能为空";
                }else if (user.getPassword().equals("")){
                    return "密码不能为空";
                }else if (userExist!=null){
                    return "账户已经存在";
                }else{
                    userMapper.save(user);
                    return "注册成功";
                }
            }catch (Exception e){
                e.printStackTrace();
                return e.getMessage();
            }

        }

        public List<User> findAll(){
            List<User> list = userMapper.findAll();
            return list;
        }

           public boolean deleteByName(Integer id){
               return userMapper.deleteByName(id) ;


           }

    }






