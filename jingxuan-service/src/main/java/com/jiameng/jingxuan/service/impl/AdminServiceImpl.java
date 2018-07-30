package com.jiameng.jingxuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiameng.jingxuan.mapper.AdminMapper;
import com.jiameng.jingxuan.mapper.ProductCategoryMapper;
import com.jiameng.jingxuan.model.domain.Admin;
import com.jiameng.jingxuan.model.domain.ProductCategory;
import com.jiameng.jingxuan.service.IAdminService;


public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminMapper adminDao;
	@Autowired
	private ProductCategoryMapper productCategoryDao;

	@Override
	public Admin getAdmin(String username) {
		return adminDao.selectByName(username);
	}

	@Override
	public boolean saveProductCategory(ProductCategory record) {
		int ret = productCategoryDao.insert(record);
		if (ret <= 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<ProductCategory> getCategory() {
		List<ProductCategory> category = productCategoryDao.getCategory();
		return category;
	}

	@Override
	public boolean updateCategoryStatus(ProductCategory category) {
		int status = productCategoryDao.updateByPrimaryKey(category);
		if (status <= 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteProductCategory(Integer id) {
		if (id > 0) {
			Integer flag = productCategoryDao.deleteByPrimaryKey(id);
			if (flag > 0) {
				return true;
			}
		}
		return false;
	}

}
