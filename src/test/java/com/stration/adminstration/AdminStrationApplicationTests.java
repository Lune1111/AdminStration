package com.stration.adminstration;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stration.adminstration.generator.mapper.UserMapper;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AdminStrationApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
       String[] words={"adc","abc","wzy"};
       int save=0;
       for(int i=0;i< words.length;i++){
           int[][] difference=new int[words.length][words.length];
           String word=words[i];
           for(int j=0;j<word.length()-1;j++){
               char num=word.charAt(j);
               char num2=word.charAt(j+1);
               difference[i][j]=num2-num;
               System.out.println("第"+i+"轮"+"输出的整数为"+difference[i][j]);
               try{
                   if((difference[i][j]!=difference[i-1][j]) || difference[i][j]!=save){
                       System.out.println(word);
                   }
               }catch (Exception exception){
                   save=difference[i][j];

               }
           }
       }
    }

}
