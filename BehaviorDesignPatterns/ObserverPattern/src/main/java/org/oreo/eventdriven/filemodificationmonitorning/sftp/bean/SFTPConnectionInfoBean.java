package org.oreo.eventdriven.filemodificationmonitorning.sftp.bean;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/12 ~ 下午 12:49
 */

public class SFTPConnectionInfoBean {

	private String serverAddress;
	private String serverPort;
	private String userName;
	private String userPassword;
	private String fileStorePath;

	public SFTPConnectionInfoBean(String serverAddress, String serverPort, String userName, String userPassword, String fileStorePath) {
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		this.userName = userName;
		this.userPassword = userPassword;
		this.fileStorePath = fileStorePath;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFileStorePath() {
		return fileStorePath;
	}

	public void setFileStorePath(String fileStorePath) {
		this.fileStorePath = fileStorePath;
	}
}
