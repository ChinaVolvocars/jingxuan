package com.jiameng.jingxuan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix=WebMVCResourceProperties.RESOURCE_PREFIX)
public class WebMVCResourceProperties {
	public static final String RESOURCE_PREFIX = "resource";
	private String session = "session_webmvc_admin";
	private String sessionHeader = "session_header";
	private String uploadAddr = "192.168.1.206:22";
	private String uploadUsername = "root";
	private String uploadPassword = "1qaz2wsx";
	private String downloadAddr = "192.168.1.206:80";
	
	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSessionHeader() {
		return sessionHeader;
	}

	public void setSessionHeader(String sessionHeader) {
		this.sessionHeader = sessionHeader;
	}

	public String getUploadAddr() {
		return uploadAddr;
	}

	public void setUploadAddr(String uploadAddr) {
		this.uploadAddr = uploadAddr;
	}

	public String getUploadUsername() {
		return uploadUsername;
	}

	public void setUploadUsername(String uploadUsername) {
		this.uploadUsername = uploadUsername;
	}

	public String getUploadPassword() {
		return uploadPassword;
	}

	public void setUploadPassword(String uploadPassword) {
		this.uploadPassword = uploadPassword;
	}

	public String getDownloadAddr() {
		return downloadAddr;
	}

	public void setDownloadAddr(String downloadAddr) {
		this.downloadAddr = downloadAddr;
	}

}
