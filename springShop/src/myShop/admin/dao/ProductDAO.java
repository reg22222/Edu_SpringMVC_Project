package myShop.admin.dao;

import java.util.List;

import myShop.admin.dto.ProductDTO;

public interface ProductDAO {
	public int insertProduct(ProductDTO dto);
	public List<ProductDTO> listProduct();
	public ProductDTO getProduct(int pnum);
	public int deleteProduct(int pnum);
	public int updateProduct(ProductDTO dto);
}
