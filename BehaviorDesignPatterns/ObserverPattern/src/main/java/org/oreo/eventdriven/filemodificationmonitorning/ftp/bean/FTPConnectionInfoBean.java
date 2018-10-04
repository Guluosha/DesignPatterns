package org.oreo.eventdriven.filemodificationmonitorning.ftp.bean;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/11 ~ 下午 7:26
 */

public class FTPConnectionInfoBean {

	private String serverAddress;
	private String userName;
	private String userPassword;
	private String fileStoragePath;

	public FTPConnectionInfoBean() {
	}

	public FTPConnectionInfoBean(String serverAddress, String userName, String userPassword, String fileStoragePath) {
		this.serverAddress = serverAddress;
		this.userName = userName;
		this.userPassword = userPassword;
		this.fileStoragePath = fileStoragePath;
	}

	public FTPConnectionInfoBean setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
		return this;
	}

	public FTPConnectionInfoBean setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public FTPConnectionInfoBean setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		return this;
	}

	public FTPConnectionInfoBean setFileStoragePath(String fileStoragePath) {
		this.fileStoragePath = fileStoragePath;
		return this;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getFileStoragePath() {
		return fileStoragePath;
	}
}