package com.example.controller.admin;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.service.ICategoryService;
import com.example.service.INewService;
import com.example.util.DisplayTagUtils;
import com.example.util.MessageResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value ="newOfAdmin")
public class NewController {

    @Autowired
    private INewService newService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private MessageResponseUtils messageResponse;

    @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
    public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) NewDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/new/list");
        DisplayTagUtils.of(request, model);
        model.setMaxPageItems(2);
        model.setListResult(newService.findAll(model));
        model.setTotalItems(newService.getTotalItem());
        String message = request.getParameter("message");
        if (message != null) {
            Map<String, String> maps = messageResponse.getMessageResponse(message);
            mav.addObject(SystemConstant.ALERT, maps.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, maps.get(SystemConstant.MESSAGE_RESPONSE));
        }
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
    public ModelAndView editNew(@ModelAttribute(SystemConstant.MODEL) NewDTO model,
                                @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/new/edit");
        String message = request.getParameter("message");
        if (id != null) {
            model = newService.findById(id);
        }
        if (message != null) {
            Map<String, String> maps = messageResponse.getMessageResponse(message);
            mav.addObject(SystemConstant.ALERT, maps.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, maps.get(SystemConstant.MESSAGE_RESPONSE));
        }
        model.setCategories(categoryService.getCategories());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
}
