package com.jiameng.jingxuan.model.domain;

import java.io.Serializable;

/**
 * banner
 * @author 
 */
public class Banner implements Serializable {
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * URL地址
     */
    private String imageUrl;

    /**
     * 排序
     */
    private Short sort;

    /**
     * 链接地址
     */
    private String linkUrl;

    /**
     * 状态：0禁用;1启用
     */
    private Short status;

    /**
     * 显示平台：1app;2web
     */
    private Short platform;

    /**
     * 分享内容
     */
    private String shareContent;

    /**
     * 1:链接地址；0：上传内容
     */
    private Short category;

    /**
     * 分享状态（是否分享：0：不可分享，1：可分享）
     */
    private Integer shareStatus;

    /**
     * 分享描述
     */
    private String shareDesc;

    /**
     * 分享链接
     */
    private String shareLink;

    /**
     * 上传内容或url地址
     */
    private String remark;

    private static final long serialVersionUID = 1L;

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
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getPlatform() {
        return platform;
    }

    public void setPlatform(Short platform) {
        this.platform = platform;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public Short getCategory() {
        return category;
    }

    public void setCategory(Short category) {
        this.category = category;
    }

    public Integer getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(Integer shareStatus) {
        this.shareStatus = shareStatus;
    }

    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}