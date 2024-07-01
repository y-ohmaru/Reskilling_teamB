//ログインシステム 石田 6/13 新規作成
//	6/14 諸橋 作成

package jp.teamB_shoppingsite.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.teamB_shoppingsite.shopping.DAO.LoginDao;
import jp.teamB_shoppingsite.shopping.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginDao loginDao;

	@ModelAttribute("loginModel")
	public LoginModel loginModel() {
		return new LoginModel();
	}


	@RequestMapping(method =RequestMethod.GET)
	public String toLogin(@ModelAttribute("loginModel") LoginModel lModel,Model model, HttpSession session) {
		if(lModel != null) {
			session.invalidate();
		}
		return "login";
	}

	@RequestMapping(method =RequestMethod.POST)
	public String toRegist(@Validated @ModelAttribute("loginModel") LoginModel lModel, BindingResult result, Model model ,HttpSession session) {

		try {
		String email = lModel.getUser_email();		//	入力されたメールアドレスを取得
		String password = lModel.getUser_password();	//	入力されたパスワードを取得
		LoginModel user = loginDao.getUsers(email , password);	//	LoginDao内のgetUsersメソッドを使用
		int join = loginDao.getUsers(email , password).getUser_join();
		if (join == 0) {
			model.addAttribute("message" ,"既に退会済みのアカウントです。");
			return "login";
		}
			if(result.hasErrors()) {
				return "login";
			}
			//入力したメールアドレスとパスワードが両方一致するフィールドがDB内にあった場合
			if(user != null) {
				session.setAttribute("loginModel", user);
				return "redirect:/top";
			}

			}catch(Exception e){
				String errormessage = "メールアドレスまたはパスワードが間違っています";
				model.addAttribute("errormessage",errormessage);
			}
			//なかった場合
			return "login";
		}
}