package com.example.controller.web;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value ="newOfWeb")
public class NewController {

    @Autowired
    private INewService newService;

    @RequestMapping(value = "/tin-tuc/{code}", method = RequestMethod.GET)
    public ModelAndView getNews(@PathVariable("code") String code) {
        ModelAndView mav = new ModelAndView("web/new/list");
        NewDTO model = new NewDTO();
        model.setListResult(newService.getNewsByCategory(code));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
}
