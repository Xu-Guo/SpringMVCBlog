package com.xuguo.controller;

import com.xuguo.model.UserEntity;
import com.xuguo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    //show user details
    //@PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    // 例如：访问 localhost:8080/admin/users/show/1 ，将匹配 id = 1
    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        //Find the user whit userId
        UserEntity userEntity = userRepository.findOne(userId);

        //pass userEntity object to return jsp page
        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }

    //update User information
    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        //find the user with userId
        UserEntity userEntity = userRepository.findOne(userId);

        //pass userEntity object to return jsp page
        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    // 更新用户信息 操作
    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity user) {

        // 更新用户信息
        userRepository.updateUser(user.getNickname(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getId());
        userRepository.flush(); // 刷新缓冲区
        return "redirect:/admin/users";
    }





}
