package cn.sp.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sp.appinfo.entity.BackendUser;
import cn.sp.appinfo.entity.DevUser;
import cn.sp.appinfo.service.BackendUserService;
import cn.sp.appinfo.service.DevUserService;

@Controller
@RequestMapping("/dev")
public class DevUserController {
	@Resource
	private DevUserService devUserService;
	@Resource BackendUserService backendUserService;
	
	//跳转到后台管理员登录页面
	@RequestMapping("/beforeLogin")
	public String beforeLogin() {
		return "backendlogin";
	}
	
	//跳转到开发者登录页面
		@RequestMapping("/devlogin")
		public String devlogin() {
			return "devlogin";
		}
	
	//开发者登录验证
		@RequestMapping("/login")
		public String login(String devCode,String devPassword,HttpSession session,Model model) {
			DevUser devUser = devUserService.Login(devCode, devPassword);
			if(devUser != null) {
				session.setAttribute("devName",devUser.getDevName());
				return "developer/main";
			}else {
				model.addAttribute("error", "用户名或者密码错误，请重新登陆！");
				return "devlogin";
			}
		}
	//后台登录验证 
	@RequestMapping("/Backlogin")
	public String Backlogin(String userCode,String userPassword,HttpSession session,Model model) {
			BackendUser back = backendUserService.Login(userCode, userPassword);
			if(back != null) {
				session.setAttribute("userName",back.getUserName());
				return "backend/main";
			}else {
				model.addAttribute("error", "用户名或者密码错误，请重新登陆！");
				return "backendlogin";
			}
		}
	//开发者注销
	@RequestMapping("/Backlogout")
		public String Backlogout(HttpSession session) {
			//让session失效
			session.invalidate();
			return "backendlogin";
		}
		
	//开发者注销
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			//让session失效
			session.invalidate();
			return "devlogin";
		}
		
	
}
