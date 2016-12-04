package com.xuguo.controller;

import com.xuguo.model.BlogEntity;
import com.xuguo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    //show all articles
    @RequestMapping(value = "admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap) {
        List<BlogEntity> blogList = blogRepository.findAll();
        modelMap.addAttribute("blogList", blogList);
        return "admin/blogs";
    }
}
