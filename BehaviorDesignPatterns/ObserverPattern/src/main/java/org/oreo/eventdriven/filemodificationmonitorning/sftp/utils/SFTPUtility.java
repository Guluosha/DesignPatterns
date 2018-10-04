package org.oreo.eventdriven.filemodificationmonitorning.sftp.utils;

import com.jcraft.jsch.*;
import org.oreo.eventdriven.filemodificationmonitorning.sftp.bean.*;

import java.io.*;
import java.util.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/12 ~ 下午 12:45
 */

public class SFTPUtility {

	private SFTPConnectionInfoBean connectionInfo;
	private ChannelSftp channelSftp;
	private Session session;
	private boolean isAutoClose = true;
	private File readyToOperateFile;

	public SFTPUtility(SFTPConnectionInfoBean connectionInfo, File readyToOperateFile) {
		this.connectionInfo = connectionInfo;
		this.readyToOperateFile = readyToOperateFile;
		initSFTPConnection(connectionInfo);
	}

	/**
	 * 是否启用自动断开连接
	 *
	 * @param choice boolean，是或否
	 * @return SFTPUtility，链式构建，返回SFTPUtility对象
	 */
	public SFTPUtility setWhetherToAutoCloseConnection(boolean choice) {
		this.isAutoClose = choice;
		return this;
	}

	/**
	 * 初始化连接
	 *
	 * @param connectionInfo 连接信息
	 */
	private void initSFTPConnection(SFTPConnectionInfoBean connectionInfo) {
		/*this.connectionInfo = connectionInfo;*/
		Properties sessionsProperties = new Properties();
		sessionsProperties.put("StrictHostKeyChecking", "no");
		JSch javaSecureChannel = new JSch();
		try {
			session = javaSecureChannel.getSession(connectionInfo.getUserName(), connectionInfo.getServerAddress(), Integer.parseInt(connectionInfo.getServerPort()));
			System.out.println("会话已建立");
			session.setPassword(connectionInfo.getUserPassword());
			session.setConfig(sessionsProperties);
			session.connect();
			System.out.println("会话已连接");
			Channel channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			System.out.println("连接服务器：" + connectionInfo.getServerAddress() + "成功");
		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传文件
	 */
	public void uploadFile() {
		System.out.println("准备开始上传文件");
		if (changeWorkingDirectoryAndStoreFile(channelSftp, readyToOperateFile)) {
			System.out.println("文件上传成功");
		} else {
			System.out.println("文件上传异常");
		}
	}

	/**
	 * 更换工作目录并保存文件
	 *
	 * @param channelSftp sftp连接通道
	 * @param file        待存储文件
	 * @return boolean，是否成功存储文件
	 */
	private boolean changeWorkingDirectoryAndStoreFile(ChannelSftp channelSftp, File file) {
		try {
			if (channelSftp.ls(connectionInfo.getFileStorePath()) != null) {
				InputStream inputStream = new FileInputStream(file);
				channelSftp.cd(connectionInfo.getFileStorePath());
				channelSftp.put(inputStream, file.getName());
				closeStream(inputStream, null);
				closeConnection(this.channelSftp, this.session);
				return true;
			}
		} catch (SftpException | FileNotFoundException e) {
			System.out.println("目录" + connectionInfo.getFileStorePath() + "不存在，准备创建该目录");
			try {
				channelSftp.mkdir(connectionInfo.getFileStorePath());
				System.out.println("创建目录" + connectionInfo.getFileStorePath() + "成功");
			} catch (SftpException e1) {
				e1.printStackTrace();
				System.out.println("本用户可能没有权限创建目录" + connectionInfo.getFileStorePath());
			}
			changeWorkingDirectoryAndStoreFile(channelSftp, file);
		}
		return false;
	}

	/**
	 * 关闭连接
	 *
	 * @param channelSftp sftp连接通道
	 * @param session     sftp会话（存储本次连接的状态信息）
	 */
	private void closeConnection(ChannelSftp channelSftp, Session session) {
		if (isAutoClose) {
			if (channelSftp != null) {
				channelSftp.disconnect();
			}
			if (session != null) {
				session.disconnect();
			}
		}
	}

	/**
	 * 关闭流
	 *
	 * @param inputStream  输入流
	 * @param outputStream 输出流
	 */
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