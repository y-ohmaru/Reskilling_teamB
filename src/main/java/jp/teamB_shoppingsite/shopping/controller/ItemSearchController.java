// 作業者:田邊大紀
// 作業日時:2024/6/17
// 概要:商品検索、商品追加コントローラ

package jp.teamB_shoppingsite.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.teamB_shoppingsite.shopping.DAO.ItemsDao;
import jp.teamB_shoppingsite.shopping.bean.ItemBean;
import jp.teamB_shoppingsite.shopping.model.ItemSearchModel;

@Controller
@RequestMapping("/item")
public class ItemSearchController {
    @Autowired
    private ItemsDao itemsDao;

    @ModelAttribute("itemSearchModel")
    public ItemSearchModel createItemSearchModel() {
        return new ItemSearchModel();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String toSearch(Model model) {
        model.addAttribute("itemSearchModel", new ItemSearchModel());
        List<ItemBean> itemsList = itemsDao.getList();
        model.addAttribute("itemsList", itemsList);
        return "itemSearch";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchItems(@ModelAttribute ItemSearchModel itemSearchModel, Model model) {
    	//商品ジャンルを取得
        Integer itemType = itemSearchModel.getItem_type();
        //商品名を取得
        String itemName = itemSearchModel.getItem_name();

        boolean itemTypeIsNull = (itemType == null || itemType == 0);
        boolean itemNameIsEmpty = (itemName == null || itemName.isEmpty());

        //ジャンル検索
        if (!itemTypeIsNull && itemNameIsEmpty) {
            List<ItemBean> itemsList = itemsDao.getItemtypeId(itemType);
            if (itemsList.isEmpty()) {
                model.addAttribute("searchMessage", "検索結果は0件です");
            } else {
                model.addAttribute("itemsList", itemsList);
            }
        //名前検索
        } else if (itemTypeIsNull && !itemNameIsEmpty) {
            List<ItemBean> itemsList = itemsDao.getListByItemName(itemName);
            if (itemsList.isEmpty()) {
                model.addAttribute("searchMessage", "検索結果は0件です");
            } else {
                model.addAttribute("itemsList", itemsList);
            }
         //名前&ジャンル検索
        } else if (!itemTypeIsNull && !itemNameIsEmpty){
        	List<ItemBean> itemsList = itemsDao.getItemIDandName(itemType,itemName);
            if (itemsList.isEmpty()) {
                model.addAttribute("searchMessage", "検索結果は0件です");
            } else {
                model.addAttribute("itemsList", itemsList);
            }

        }else if (itemTypeIsNull && itemNameIsEmpty){
        	model.addAttribute("searchMessage", "ジャンルか商品名のいずれかを入力してください");
        	model.addAttribute("itemSearchModel", new ItemSearchModel());
            List<ItemBean> itemsList = itemsDao.getList();
            model.addAttribute("itemsList", itemsList);
        }
        return "itemSearch";
    }


    //カートに商品を追加
    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@RequestParam("item_id") int itemId, @RequestParam("quantity") int quantity, HttpSession session, Model model) {

    	@SuppressWarnings("unchecked")
		ArrayList<Integer> cartItems = (ArrayList<Integer>) session.getAttribute("cartItems");
    	if(cartItems == null) {	//cartItemがnullだった場合
    		cartItems = new ArrayList<>();
		}
    	//要素数ごとにリスト作成
        for(int i=0 ; i < quantity ; i++) {
        	cartItems.add(itemId);
        }
        List<ItemBean> itemsList = itemsDao.getItemId(itemId);
		model.addAttribute("itemsList", itemsList);
        session.setAttribute("cartItems", cartItems);
        model.addAttribute("message", "カートに追加されました");
        return "itemSearch";
    }
}
