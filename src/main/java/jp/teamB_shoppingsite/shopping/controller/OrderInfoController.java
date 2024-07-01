// 注文情報コントローラー
//	6/20 並河作成
//	6/20 諸橋修正
//	6/24 伊藤修正
package jp.teamB_shoppingsite.shopping.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.teamB_shoppingsite.shopping.DAO.CartCheckDao;
import jp.teamB_shoppingsite.shopping.DAO.OrderDao;
import jp.teamB_shoppingsite.shopping.DAO.UserInfoDao;
import jp.teamB_shoppingsite.shopping.model.CartCheckModel;
import jp.teamB_shoppingsite.shopping.model.LoginModel;
import jp.teamB_shoppingsite.shopping.model.UserInfoModel;
import jp.teamB_shoppingsite.shopping.model.UserModel;

@Controller
@RequestMapping("/orderinfo")
public class OrderInfoController {

	@Autowired CartCheckDao cartCheckDao;
	@Autowired OrderDao orderDao;
	@Autowired UserInfoDao userInfoDao;

	int totalprice = 0;

	@RequestMapping(method =RequestMethod.GET)
	public String toOrderInfo(@ModelAttribute("userModel") UserModel uModel, Model model, HttpSession session) {
		totalprice =0;
		model.addAttribute("userModel", new UserModel());
		return "orderinfo";
	}

	@RequestMapping(params="backcart" , method =RequestMethod.POST)
	public String goBackCart(Model model) {
		return "redirect:/cartcheck";
	}


	@RequestMapping(params="orderregist" , method =RequestMethod.POST)
	public String goOrderInfo(@ModelAttribute("userModel") UserModel uModel, HttpSession session, Model model) {

		@SuppressWarnings("unchecked")
		ArrayList<Integer> CartItemList = (ArrayList<Integer>) session.getAttribute("cartItems");
		ArrayList<CartCheckModel> itemlist = new ArrayList<CartCheckModel>();		// CartCheckModel型のリストを作成
				//合計金額格納用変数
		//int totalprice = 0;
		//UserModel orderUser =(UserModel)session.getAttribute("userModel");
		if(uModel.getUser_address().equals("")) {
			model.addAttribute("errorMessage","住所は必須入力です");
			totalprice =0;
			return "orderinfo";
		}

		for (Integer item :CartItemList) {		// カート内の商品点数分繰り返し
			itemlist.add(cartCheckDao.getItems(item));		// cartCheckDaoのgetItemsメソッドを使用し商品情報を取得
			totalprice = totalprice + cartCheckDao.getItems(item).getItem_price(); // 金額を追加
		}
		String pricemessage=  totalprice+ "円";
		model.addAttribute("itemlist",itemlist);
		model.addAttribute("pricemessage", pricemessage);
		session.setAttribute("userModel", uModel);


		return "orderConfirmation";
	}

	@RequestMapping(params="orderInput" , method =RequestMethod.POST)
	public String toOrder(Model model) {
		return "redirect:/orderinfo";
	}

	@RequestMapping(params="orderForward" , method =RequestMethod.POST)
	public String toForward(@ModelAttribute("userModel") UserModel uModel, @ModelAttribute("cartCheckModel") CartCheckModel cModel,Model model, HttpSession session) {
		LoginModel user = (LoginModel) session.getAttribute("loginModel");
		UserModel orderUser =(UserModel)session.getAttribute("userModel");
		ArrayList<Integer> CartItemList = (ArrayList<Integer>) session.getAttribute("cartItems");
		UserInfoModel info = userInfoDao.getUsers(user.getUser_email());
		int insertOrder = orderDao.orderInsert(info, totalprice);


		List<Integer> order = orderDao.order(info);
		int idmax = Collections.max(order);
		int insertDetailOrder = 0;
		for (Integer itemID:CartItemList) {
			insertDetailOrder = orderDao.orderDetailInsert(orderUser, itemID, totalprice, idmax);
		}
		if(insertOrder == 1 && insertDetailOrder >= 1) {
			session.removeAttribute("cartItems");
			return "orderComplete";
		}else{
			return "redirect:/orderinfo";
		}
	}
}