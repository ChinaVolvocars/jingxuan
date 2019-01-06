package com.jiameng.jingxuan.mapper;

import com.jiameng.jingxuan.model.domain.Banner;
import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
  Banner selectByPrimaryKey(@Param("id") Integer id);
}
