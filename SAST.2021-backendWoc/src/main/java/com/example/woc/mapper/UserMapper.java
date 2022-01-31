package com.example.woc.mapper;

import com.example.woc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();
    User findByName(String name);
    String findPswByName(String UserName);
    void save(User user);
    void delete(Integer id);
    boolean deleteByName(Integer id);
}







