package com.xuguo.controller;

import com.xuguo.model.BlogEntity;
import com.xuguo.model.UserEntity;
import com.xuguo.repository.BlogRepository;
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
 * Created by xuxu on 12/3/16.
 */
@Controller
public class BlogController {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    //show all articles
    @RequestMapping(value = "admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap) {
        List<BlogEntity> blogList = blogRepository.findAll();
        modelMap.addAttribute("blogList", blogList);
        return "admin/blogs";
    }

    //add blog
    @RequestMapping(value = "admin/blogs/add", method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap) {
        List<UserEntity> userList = userRepository.findAll();
        //inject user list
        modelMap.addAttribute("userList", userList);
        return "admin/addBlog";
    }

    //add blog, use http post method, jump to blogs.jsp

    @RequestMapping(value = "admin/blogs/addP", method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog") BlogEntity blogEntity) {
        //print blog title
        System.out.println(blogEntity.getTitle());
        //print blog author
        System.out.println(blogEntity.getUserByUserId().getNickname());
        //insert into database
        blogRepository.saveAndFlush(blogEntity);
        //redirect to blogs.jsp
        return "redirect:/admin/blogs";
    }

    //show blog detail
    @RequestMapping("/admin/blogs/show/{id}")
    public String showBlog(@PathVariable("id") int id, ModelMap modelMap) {
        BlogEntity blog = blogRepository.findOne(id);
        modelMap.addAttribute("blog", blog);
        return "admin/blogDetail";
    }

}
