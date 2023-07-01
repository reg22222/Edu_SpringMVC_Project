package myShop.admin.dao;

import java.util.List;

import myShop.admin.dto.CategoryDTO;

public interface CategoryDAO {
	public int insertCategory(CategoryDTO dto);
	public int deleteCategory(int cnum);
	public List<CategoryDTO> listCategory();
}
