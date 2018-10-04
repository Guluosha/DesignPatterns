package org.oreo.eventdriven.filemodificationmonitorning.ftp.utils;

import eventdriven.filemodificationmonitorning.ftp.bean.FTPConnectionInfoBean;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.InetAddress;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/11 ~ 下午 7:43
 */

public class FTPUtility {

	private FTPClient ftpClient;
	private FTPConnectionInfoBean connectionInfo;
	private boolean isAutoClose = false;

	public void setWhetherToAutoCloseConnection(boolean choice) {
		this.isAutoClose = choice;
	}

	public void initFTPConnection(FTPConnectionInfoBean connectionInfo) {
		this.connectionInfo = connectionInfo;
		ftpClient = new FTPClient();
		ftpClient.setControlEncoding("uft-8");
		System.out.println("正在连接服务器，地址：" + connectionInfo.getServerAddress());
		try {
			ftpClient.connect(InetAddress.getByName(connectionInfo.getServerAddress()));
			ftpClient.login(connectionInfo.getUserName(), connectionInfo.getUserPassword());
			if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				System.out.println("成功连接服务器，地址：" + connectionInfo.getServerAddress());
			} else {
				System.out.println("连接失败，错误信息：" + ftpClient.getStatus());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void uploadFile(File file) {
		System.out.println("准备开始上传文件");
		try {
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			changeWorkingDirectoryAndStoreFile(ftpClient, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void downloadFile() {

	}

	public void deleteFile() {

	}

	private boolean changeWorkingDirectoryAndStoreFile(FTPClient ftpClient, File file) {
		try {
			if (ftpClient.changeWorkingDirectory(connectionInfo.getFileStoragePath())) {
				InputStream fileInputStream = new FileInputStream(file);
				if (ftpClient.storeFile(connectionInfo.getFileStoragePath(), fileInputStream)) {
					System.out.println("文件上传成功");
					closeStream(fileInputStream, null);
					closeConnection(ftpClient);
				}
				return true;
			}
			if (createDirectory()) {
				changeWorkingDirectoryAndStoreFile(ftpClient, file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean createDirectory() {
		try {
			if (ftpClient.mkd(connectionInfo.getFileStoragePath()) == 0) {
				System.out.println("目录" + connectionInfo.getFileStoragePath() + "创建成功");
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void closeConnection(FTPClient ftpClient) {
		if (isAutoClose) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeStream(InputStream inputStream, OutputStream outputStream) {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}