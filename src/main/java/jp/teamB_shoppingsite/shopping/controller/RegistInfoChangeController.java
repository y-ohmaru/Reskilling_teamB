//会員情報変更画面 石田 作成
package jp.teamB_shoppingsite.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.teamB_shoppingsite.shopping.DAO.RegistInfoChangeDao;
import jp.teamB_shoppingsite.shopping.model.LoginModel;
import jp.teamB_shoppingsite.shopping.model.RegistInfoChangeModel;

@Controller
@RequestMapping("/RegistInfoChange")
@SessionAttributes("RegistInfoChangeModel")
public class RegistInfoChangeController {

	public static int btncount;

	@Autowired RegistInfoChangeDao registInfoChangeDao;

	@ModelAttribute("RegistInfoChangeModel")
	public RegistInfoChangeModel setupRegistInfoChangeModel() {
		return new RegistInfoChangeModel();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String toRegistInfoChange(@ModelAttribute("RegistInfoChangeModel") RegistInfoChangeModel riModel, Model model,HttpSession session) {
		LoginModel user = (LoginModel) session.getAttribute("loginModel");	//sessionオブジェクトからloginModelの情報を取得
		String email = user.getUser_email();
		RegistInfoChangeModel userUi = registInfoChangeDao.getUsers(email);
		model.addAttribute("RegistInfoChangeModel", userUi);
		return "RegistInfoChange";
	}
	//ユーザーとパスワードの照合
	@RequestMapping(method =RequestMethod.POST)
	public String toRegistInfoChangeModel(@ModelAttribute("RegistInfoChangeModel") RegistInfoChangeModel registInfoChangeModel, Model model ,HttpSession session) {
		LoginModel user = (LoginModel) session.getAttribute("loginModel");
		if(user.getUser_password().equals(registInfoChangeModel.getUser_password())) {
			btncount =0;
			if(registInfoChangeModel.getNew_password() != "" &&
					registInfoChangeModel.getNew_passwordCheck() != "" &&
					registInfoChangeModel.getNew_password().equals(registInfoChangeModel.getNew_passwordCheck())) {
				registInfoChangeDao.registChange(registInfoChangeModel.getUser_name(), registInfoChangeModel.getUser_email(), registInfoChangeModel.getNew_password(), user.getUser_email());

			}else {
					model.addAttribute("message", "新しいパスワードが一致していません。(パスワードは必ず必要です)");
					return "RegistInfoChange";
				}
		}else {
			model.addAttribute("message", "正しい古いパスワードを入力してください。");
			return "RegistInfoChange";
		}
		return "RegistChangeComplete";
	}


	//退会ボタンで退会完了画面へ遷移
	@RequestMapping(method = RequestMethod.POST,params="Secession")
	public String toSecession(@ModelAttribute("RegistInfoChangeModel") RegistInfoChangeModel registInfoChangeModel, Model model ,HttpSession session) {
		LoginModel user = (LoginModel) session.getAttribute("loginModel");
		if(user.getUser_password().equals(registInfoChangeModel.getUser_password())) {
			btncount++;
			if(btncount == 1) {
				model.addAttribute("message" , "退会処理を実施します。よろしいですか?");
				model.addAttribute("message2" , "(よろしい場合は、再度退会ボタンをクリックしてください)");
				return "RegistInfoChange";
			}else if(btncount == 2) {
				registInfoChangeDao.toSecession(user.getUser_email());
				session.invalidate();
			}
			return "Secession";
		}else {
			btncount =0;
			model.addAttribute("message", "正しいパスワードを入力してください。");
			return "RegistInfoChange";
		}
	}
}