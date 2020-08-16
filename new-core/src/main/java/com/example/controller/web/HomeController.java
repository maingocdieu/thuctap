package com.example.controller.web;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.service.ICategoryService;
import com.example.service.INewService;
import com.example.service.ISanPhamService;
import com.example.util.MessageResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller(value ="homeOfWeb")
public class HomeController {

	@Autowired
	private ISanPhamService sanPhamService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private INewService newService;
	@Autowired
	private MessageResponseUtils messageResponse;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("listSP", sanPhamService.findAll());
		String message = request.getParameter("message");
		if (message != null) {
			Map<String, String> maps = messageResponse.getMessageResponse(message);
			mav.addObject(SystemConstant.ALERT, maps.get(SystemConstant.ALERT));
			mav.addObject(SystemConstant.MESSAGE_RESPONSE, maps.get(SystemConstant.MESSAGE_RESPONSE));
		}
		return mav;
	}

	@RequestMapping(value = "/trang-chu/{code}", method = RequestMethod.GET)
	public ModelAndView getNews(@PathVariable("code") String code) {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("listSP", sanPhamService.getSanPhamByCategory(code));
		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/dang-ki", method = RequestMethod.GET)
	public ModelAndView dangkiPage() {
		ModelAndView mav = new ModelAndView("dangki");
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/trang-chu";
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDenied() {
		return "redirect:/dang-nhap?accessDenied";
	}
}
