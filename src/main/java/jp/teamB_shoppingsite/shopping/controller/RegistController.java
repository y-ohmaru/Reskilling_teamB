package jp.teamB_shoppingsite.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.teamB_shoppingsite.shopping.DAO.RegistDao;
import jp.teamB_shoppingsite.shopping.model.RegistModel;

@Controller
@RequestMapping("regist")
@SessionAttributes("registModel")
public class RegistController {

	@Autowired RegistDao registDao;

	@ModelAttribute("registModel")
	public RegistModel setupRegistModel() {
		return new RegistModel();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String toRegist() {
		return "regist";
	}

	@RequestMapping(method = RequestMethod.POST, params = "back")
	public String toTop() {
		return "redirect:/login";
	}

	@RequestMapping(method = RequestMethod.POST, params = "go")
	public String toResult(@ModelAttribute RegistModel rModel , Model model) {
		RegistModel regist = new RegistModel();
		regist.setName(rModel.getName());
		regist.setMail(rModel.getMail());
		regist.setMailCheck(rModel.getMailCheck());
		regist.setPassword(rModel.getPassword());
		regist.setPasswordCheck(rModel.getPasswordCheck());
		if(rModel.getMail().equals(rModel.getMailCheck()) &&
				rModel.getPassword().equals(rModel.getPasswordCheck())) {
			if(rModel.getMail() != "" && rModel.getPassword() !="") {
				int insertUser = registDao.insert(regist);
				return "forward:/confirm";
			}else {
				model.addAttribute("message", "メールアドレス、パスワードは必須入力です。");
				return "regist";
			}
		}
		model.addAttribute("message" , "メールアドレスもしくはパスワードが一致していません");
		return null;
	}
}
