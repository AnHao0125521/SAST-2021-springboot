package com.example.woc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 03:54
 **/
//Lombok的注解
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;

        public void setId(Integer id){
            this.id = id;
        }
        public Integer getId(){
            return id;
        }
        public void setUsername(String username){
            this.username = username;
        }
        public String getUsername(){
            return username;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public String getPassword(){
            return password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", user_name='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ",email='" + email+'\''+
                    '}';
        }




}
