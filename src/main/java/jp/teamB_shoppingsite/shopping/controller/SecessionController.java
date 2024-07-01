package jp.teamB_shoppingsite.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("Secession")
public class SecessionController {

	@RequestMapping(method = RequestMethod.GET)
	public String toSecession() {
		return "Secession";
}

	@RequestMapping(method = RequestMethod.POST, params = "back")
		public String toTop() {
		return "redirect:/top";
	}
}
