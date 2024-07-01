package jp.teamB_shoppingsite.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("confirm")
@SessionAttributes("RegistModel")
public class ConfirmController {


	@RequestMapping(method = RequestMethod.POST)
	public String toLogin(Model model) {
		return "registConfirm";
	}


	@RequestMapping(method = RequestMethod.POST, params = "login")
	public String toLogin(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:login";
	}
}