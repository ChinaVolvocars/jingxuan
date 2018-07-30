package com.jiameng.jingxuan.model.domain;

import java.util.Date;

public class Product {
    private Integer id;

    private String name;

    private Integer categoryId;

    private Integer sort;

    private String imgUrlWeb;

    private String imgUrlApp;

    private String imgUrlMain;

    private Date createTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getImgUrlWeb() {
        return imgUrlWeb;
    }

    public void setImgUrlWeb(String imgUrlWeb) {
        this.imgUrlWeb = imgUrlWeb == null ? null : imgUrlWeb.trim();
    }

    public String getImgUrlApp() {
        return imgUrlApp;
    }

    public void setImgUrlApp(String imgUrlApp) {
        this.imgUrlApp = imgUrlApp == null ? null : imgUrlApp.trim();
    }

    public String getImgUrlMain() {
        return imgUrlMain;
    }

    public void setImgUrlMain(String imgUrlMain) {
        this.imgUrlMain = imgUrlMain == null ? null : imgUrlMain.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}