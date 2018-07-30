package com.jiameng.jingxuan.service;

import java.util.List;

import com.jiameng.jingxuan.model.domain.Admin;
import com.jiameng.jingxuan.model.domain.ProductCategory;

public interface IAdminService {

	Admin getAdmin(String username);

	boolean saveProductCategory(ProductCategory record);

	List<ProductCategory> getCategory();

	boolean updateCategoryStatus(ProductCategory category);

	boolean deleteProductCategory(Integer id);

}
