/** 会員情報確認システム 2024/6/19 諸橋作成 */

package jp.teamB_shoppingsite.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.teamB_shoppingsite.shopping.DAO.UserInfoDao;
import jp.teamB_shoppingsite.shopping.model.LoginModel;
import jp.teamB_shoppingsite.shopping.model.UserInfoModel;

@Controller
@RequestMapping("/userinfo")
@SessionAttributes("userInfoModel")
public class UserInfoController {

	@Autowired
	private UserInfoDao userInfoDao;

	@ModelAttribute("userInfoModel")
	public UserInfoModel setupUserInfoModel() {
		return new UserInfoModel();
	}

	@RequestMapping(method =RequestMethod.GET)
	public String toUserInfo(@ModelAttribute("userInfoModel") UserInfoModel uiModel, Model model,HttpSession session) {

		LoginModel user = (LoginModel) session.getAttribute("loginModel");	//sessionオブジェクトからloginModelの情報を取得
		String email = user.getUser_email();
		UserInfoModel useri = userInfoDao.getUsers(email);
		model.addAttribute("userInfoModel", useri);
		return "userinfo";
	}


	@RequestMapping(method =RequestMethod.POST)
	public String toChange(@ModelAttribute("userInfoModel") UserInfoModel uiModel, Model model,HttpSession session) {
		return "RegistInfoChange";
	}
}