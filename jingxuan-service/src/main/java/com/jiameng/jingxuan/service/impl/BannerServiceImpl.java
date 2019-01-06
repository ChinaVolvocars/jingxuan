package com.jiameng.jingxuan.service.impl;

import com.jiameng.jingxuan.mapper.BannerMapper;
import com.jiameng.jingxuan.model.domain.Banner;
import com.jiameng.jingxuan.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;

public class BannerServiceImpl implements BannerService {

  @Autowired
  BannerMapper bannerDao;

  @Override
  public Banner getBannerById(Integer id) {
    return bannerDao.selectByPrimaryKey(id);
  }
}
