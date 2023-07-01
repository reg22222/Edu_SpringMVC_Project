package myShop.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import myShop.admin.dao.CategoryDAO;
import myShop.admin.dao.ProductDAO;
import myShop.admin.dto.CategoryDTO;
import myShop.admin.dto.ProductDTO;

@Controller
public class ShopAdminController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/shop_admin.do")
	public String admin_index() {
		return "admin/main";
	}
	
	@RequestMapping(value="/cate_input.do", method=RequestMethod.GET) 
	public String admin_cateInput() {
		return "admin/cate_input";
	}
	
	@RequestMapping(value="/cate_input.do", method=RequestMethod.POST) 
	public String admin_cateInput_ok(HttpServletRequest req, @ModelAttribute CategoryDTO dto) {
		int res = categoryDAO.insertCategory(dto);
		if (res>0) {
			req.setAttribute("msg", "카테고리 등록 성공!! 카테고리 목록 페이지로 이동합니다.");
			req.setAttribute("url", "cate_list.do");
		}else {
			req.setAttribute("msg", "카테고리 등록 실패!! 카테고리 등록 페이지로 이동합니다.");
			req.setAttribute("url", "cate_input.do");
		}
		return "forward:message.jsp";
	}
	
	@RequestMapping("/cate_list.do")
	public ModelAndView admin_cateList() {
		List<CategoryDTO> list = categoryDAO.listCategory();
		return new ModelAndView("admin/cate_list", "listCate", list);
	}
	
	@RequestMapping("/cate_delete.do")
	public String admin_cateDelete(int cnum) {
		int res = categoryDAO.deleteCategory(cnum);
		return "redirect:cate_list.do";
	}
	
	@RequestMapping(value="/cate_input.do", method=RequestMethod.GET)
	public String admin_prodInput(HttpServletRequest req) {
		List<CategoryDTO> list = categoryDAO.listCategory();
		if (list == null || list.size() == 0) {
			req.setAttribute("msg", "등록된 카테고리가 없습니다. 카테고리를 등록후 사용하실 수 있습니다.");
			req.setAttribute("url", "shop_admin.do");
			return "forward:message.jsp";
		}
		req.setAttribute("listCate", list);
		return "admin/cate_input";
	}
	
	@RequestMapping(value="/cate_input.do", method=RequestMethod.POST)
	public String admin_prodInput_ok
			(HttpServletRequest req, @ModelAttribute ProductDTO pdto) {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile mf = mr.getFile("pimage");
		String filename = mf.getOriginalFilename();
		
		HttpSession session = req.getSession();
		String upPath = session.getServletContext().getRealPath("/files");
		File file = new File(upPath, filename);
		try {
			mf.transferTo(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		pdto.setPcategory_fk(req.getParameter("code") + req.getParameter("pcode"));
		
		int res = productDAO.insertProduct(pdto);
		if (res>0) {
			req.setAttribute("msg", "상품 등록 성공!! 상품 목록 페이지로 이동합니다.");
			req.setAttribute("url", "prod_list.do");
		}else {
			req.setAttribute("msg", "상품 등록 실패!! 상품 등록 페이지로 이동합니다.");
			req.setAttribute("url", "prod_input.do");
		}
		return "forward:message.jsp";
	}
}














