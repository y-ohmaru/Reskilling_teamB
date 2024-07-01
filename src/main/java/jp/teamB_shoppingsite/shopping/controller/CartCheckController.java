/** カート内確認システム 2024/6/17 諸橋作成 */

package jp.teamB_shoppingsite.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.teamB_shoppingsite.shopping.DAO.CartCheckDao;
import jp.teamB_shoppingsite.shopping.model.CartCheckModel;

@Controller
@RequestMapping("/cartcheck")
@SessionAttributes("cartCheckModel")
public class CartCheckController {

	@Autowired CartCheckDao cartCheckDao;

	ArrayList<Integer> samplelist = new ArrayList<Integer>();

	@ModelAttribute("cartCheckModel")
	public CartCheckModel setupCartCheckModel() {
		return new CartCheckModel();
	}

	@RequestMapping(method =RequestMethod.GET)
	public String toCartCheck(Model model , HttpSession session) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer> CartItemList = (ArrayList<Integer>) session.getAttribute("cartItems");
		if(CartItemList == null) {	//cartItemがnullだった場合
			CartItemList = new ArrayList<>();
		}
		ArrayList<CartCheckModel> itemlist = new ArrayList<CartCheckModel>();		// CartCheckModel型のリストを作成
		int totalprice = 0;		//合計金額格納用変数

		for (Integer item :CartItemList) {		// カート内の商品点数分繰り返し
			itemlist.add(cartCheckDao.getItems(item));		// cartCheckDaoのgetItemsメソッドを使用し商品情報を取得
			totalprice = totalprice + cartCheckDao.getItems(item).getItem_price(); // 金額を追加
		}

		String pricemessage = "合計：" + totalprice + "円";
		if(totalprice == 0) {
			model.addAttribute("pricemessage", "カート内に商品がありません");
		}else {
		model.addAttribute("pricemessage", pricemessage);
		}
		model.addAttribute("itemlist",itemlist);
		return "CartCheck";
	}



	@RequestMapping(params="delete" , method =RequestMethod.POST)	//deleteボタンが押下された場合
	public String toItemDelete(@Validated @ModelAttribute @RequestParam("index")int index ,CartCheckModel ccModel, BindingResult result ,Model model,HttpSession session) {

		@SuppressWarnings("unchecked")
		ArrayList<Integer> CartItemList = (ArrayList<Integer>) session.getAttribute("cartItems");
		ArrayList<CartCheckModel> itemlist = new ArrayList<CartCheckModel>();// CartCheckModel型のリストを作成
		CartItemList.remove(index);	//カート内リスト一品削除

		int totalprice = 0;		//合計金額格納用変数
		for (Integer item :CartItemList) {		// カート内の商品点数分繰り返し
			itemlist.add(cartCheckDao.getItems(item));		// cartCheckDaoのgetItemsメソッドを使用し商品情報を取得
			totalprice = totalprice + cartCheckDao.getItems(item).getItem_price(); // 金額を追加
		}
		String pricemessage="合計：" + totalprice+ "円";
		model.addAttribute("itemlist",itemlist);
		if(totalprice == 0) {
			model.addAttribute("pricemessage", "カート内に商品がありません");
		}else {
		model.addAttribute("pricemessage", pricemessage);
		}
		session.setAttribute("cartItems", CartItemList);
		return "CartCheck";
	}



	@RequestMapping(method =RequestMethod.POST , params="Order")	//Orderボタンが押下された場合
	public String toOrder(Model model,HttpSession session) {
		return "/orderinfo";	//orderinfo画面に遷移
	}


	@RequestMapping(method =RequestMethod.POST , params="itemSearch")	//itemSearchボタンが押下された場合
	public String toSearch(Model model,HttpSession session) {
		return "item/search";	//itemSearch画面に遷移
	}
}
