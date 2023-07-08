package myShop.mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myShop.admin.dao.CategoryDAO;
import myShop.admin.dao.ProductDAO;
import myShop.admin.dto.CategoryDTO;
import myShop.admin.dto.ProductDTO;

@Controller
public class ShopMallController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductList productList;
	
	@RequestMapping("index.do")
	public String index() {
		return "redirect:index.jsp";
	}
	@RequestMapping("/shop_mall.do")
	public String shop_mall(HttpServletRequest req) {
		List<CategoryDTO> clist = categoryDAO.listCategory();
		if (clist == null || clist.size() == 0) {
			req.setAttribute("msg", "쇼핑몰 준비중 입니다. 나중에 이용해 주세요!!");
			req.setAttribute("url", "index.do");
			return "forward:message.jsp";
		}
		HttpSession session = req.getSession();
		session.setAttribute("listCategory", clist);

		List<ProductDTO> new_list = productList.selectByPspec("NEW");
		List<ProductDTO> best_list = productList.selectByPspec("BEST");
		List<ProductDTO> hit_list = productList.selectByPspec("HIT");
		
		req.setAttribute("upPath", req.getServletContext().getRealPath("/files"));
		req.setAttribute("newa", new_list);
		req.setAttribute("best", best_list);
		req.setAttribute("hit", hit_list);
						
		return "display/mall";
	}

	@RequestMapping("/mall_cgProdList.do")
	public String mall_cgProdList(HttpServletRequest req, @RequestParam Map<String, String> map) {
		List<ProductDTO> code_list = productList.selectByCode(map.get("code"));
		
		req.setAttribute("upPath", req.getServletContext().getRealPath("/files"));
		req.setAttribute("code", code_list);
		
		return "display/mall_cgProdList";
	}
	
	@RequestMapping("/mall_prodView.do")
	public String mall_prodView(HttpServletRequest req, @RequestParam Map<String, String> map) {
		ProductDTO dto = productList.getProduct(map);
		req.setAttribute("getProduct", dto);
		req.setAttribute("upPath", req.getServletContext().getRealPath("/files"));
		return "display/mall_prodView";
	}
	
	@RequestMapping("/mall_cartAdd.do")
	public String mall_cartAdd(HttpServletRequest req, @RequestParam Map<String, String> map) {
		HttpSession session = req.getSession();
		List<ProductDTO> cart_list = (List)session.getAttribute("cart");
		if (cart_list == null) cart_list = new ArrayList<ProductDTO>();
		ProductDTO dto = productList.getProduct(map);
		dto.setPqty(Integer.parseInt(map.get("pqty")));
		cart_list.add(dto);
		session.setAttribute("cart", cart_list);
		return "redirect:mall_cartList.do";
	}
	
	@RequestMapping("/mall_cartList.do")
	public String mall_cartList(HttpServletRequest req) {
		req.setAttribute("upPath", req.getServletContext().getRealPath("/files"));
		return "display/mall_cartList";
	}
	
	@RequestMapping("/mall_cartDel.do")
	public String mall_cartDel(HttpServletRequest req, int pnum) {
		HttpSession session = req.getSession();
		List<ProductDTO> cart_list = (List)session.getAttribute("cart");
		for(ProductDTO dto : cart_list) {
			if (dto.getPnum() == pnum) {
				cart_list.remove(dto);
				break;
			}
		}
		session.setAttribute("cart", cart_list);
		return "redirect:mall_cartList.do";
	}
	
	@RequestMapping("/mall_cartEdit.do")
	public String mall_cartEdit(HttpServletRequest req, @RequestParam Map<String, String> map) {
		int pqty = Integer.parseInt(map.get("pqty"));
		int pnum = Integer.parseInt(map.get("pnum"));
		if (pqty == 0) {
			return "redirect:mall_cartDel.do?pnum=" + pnum;
		}else {
			HttpSession session = req.getSession();
			List<ProductDTO> cart_list = (List)session.getAttribute("cart");
			for(ProductDTO dto : cart_list) {
				if (pnum == dto.getPnum()) {
					dto.setPqty(pqty);
					break;
				}
			}
			session.setAttribute("cart", cart_list);
		}
		
		return "redirect:mall_cartList.do";
	}
}













