package com.example.controller.admin;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.util.DisplayTagUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value ="categoryOfAdmin")
public class CategoryController {

    @RequestMapping(value = "/admin/category/list", method = RequestMethod.GET)
    public ModelAndView getNews() {
        ModelAndView mav = new ModelAndView("admin/category/list");
        return mav;
    }
}
