package com.example.controller.admin;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.dto.SanPhamDTO;
import com.example.service.ICategoryService;
import com.example.service.INewService;
import com.example.service.ISanPhamService;
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
import java.util.List;
import java.util.Map;

@Controller(value ="sanPhamOfAdmin")
public class SanPhamController {

    @Autowired
    private ISanPhamService sanPhamService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private MessageResponseUtils messageResponse;

    @RequestMapping(value = "/admin/sanpham/list", method = RequestMethod.GET)
    public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) SanPhamDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/sanpham/list");
        DisplayTagUtils.of(request, model);
        model.setMaxPageItems(5);
        model.setListResult(sanPhamService.findAll(model));
        model.setTotalItems(sanPhamService.getTotalItem());
        String message = request.getParameter("message");
        if (message != null) {
            Map<String, String> maps = messageResponse.getMessageResponse(message);
            mav.addObject(SystemConstant.ALERT, maps.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, maps.get(SystemConstant.MESSAGE_RESPONSE));
        }
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/sanpham/edit", method = RequestMethod.GET)
    public ModelAndView editNew(@ModelAttribute(SystemConstant.MODEL) SanPhamDTO model,
                                @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/sanpham/edit");
        String message = request.getParameter("message");
        if (id != null) {
            model = sanPhamService.findById(id);
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
