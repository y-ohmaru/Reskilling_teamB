package jp.teamB_shoppingsite.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderController {

	@RequestMapping(value = "top", method = RequestMethod.GET)
	public String toTop() {
		return "top";
	}

	//ログイン
	@RequestMapping(method = RequestMethod.POST, params = "login")
	public String toLogin(){
		return "redirect:/login";
	}
}
