package com.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.User;
import com.edu.service.UserService;
import com.edu.util.JsonWithMsg;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//登录
	@ResponseBody
	@RequestMapping("/login")
	public JsonWithMsg login(User user,HttpServletRequest request) {
		if(userService.getUser(user)!=null){
			request.getSession().setAttribute("userInfo", user);
			System.out.println(user);
			return JsonWithMsg.success().setMsg("manage.jsp");
		}else {
			return JsonWithMsg.fail().setMsg("用户名或密码错误");
		}
	}
	
	//注销
	@RequestMapping("/logout")
	public String logou(HttpServletRequest request) {
		request.getSession().invalidate();
		 return "redirect:/login.jsp";
	}
	
	//修改个人信息
}
