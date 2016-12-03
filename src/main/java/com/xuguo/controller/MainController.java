package com.xuguo.controller;

import com.xuguo.model.UserEntity;
import com.xuguo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by xuxu on 12/2/16.
 */
@Controller
public class MainController {

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        System.out.println("*********controller hello!***********");
        return "index";
    }

    @RequestMapping(value = "/admin/users",method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap){

        //use JpaRepositiry findAll() method to find all the records
        //find all user records in user table
        List<UserEntity> userList = userRepository.findAll();

        //modelMap: can pass argus from controller method to jsp for view display
        //pass all records to return jsp page in userList
        modelMap.addAttribute("userList",userList);

        //return pages/admin/users.jsp
        return "admin/users";
    }

    @RequestMapping(value = "/admin/users/add",method = RequestMethod.GET)
    public String addUser(){
        //jump to admin/addUser.jsp
        return "admin/addUser";
    }

    //post request, handle add user request and return back to /admin/users.jsp (user management page)
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user")UserEntity userEntity){
        //post request passes a UserEntity object which contains the information of this user
        //with @ModelAttribute() annotation, we can obtain the user information and create a object

        //add one user, after save() method, data kept in buffer, not added to database
        //userRepository.save(userEntity);

        //add one user and insert into database, saveAndFlush() method flushes changes instantly
        userRepository.saveAndFlush(userEntity);

        // redirect:url
        return "redirect:/admin/users";
    }









}
