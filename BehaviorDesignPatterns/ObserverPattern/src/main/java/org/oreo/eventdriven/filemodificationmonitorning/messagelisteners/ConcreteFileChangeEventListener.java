package org.oreo.eventdriven.filemodificationmonitorning.messagelisteners;

import org.oreo.eventdriven.filemodificationmonitorning.commands.*;
import org.oreo.eventdriven.filemodificationmonitorning.interfaces.*;
import org.oreo.eventdriven.filemodificationmonitorning.sftp.bean.*;
import org.oreo.eventdriven.filemodificationmonitorning.sftp.utils.*;
import org.oreo.eventdriven.filemodificationmonitorning.workerthread.*;

import java.io.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/6/27 ~ 下午 11:37
 */

public class ConcreteFileChangeEventListener extends AbstractFileChangeEventListener {

	private SFTPConnectionInfoBean sftpConnectionInfoBean;
	private static SubmitChangedFileThread SUBMITCHANGEDFILETHREAD = new SubmitChangedFileThread();
//	private SFTPConnectionInfoBean sftpConnectionInfoBean = new SFTPConnectionInfoBean("10.11.61.39", "22", "spdb", "spdb12345", "");

	public ConcreteFileChangeEventListener setSftpConnectionInfoBean(SFTPConnectionInfoBean sftpConnectionInfoBean) {
		this.sftpConnectionInfoBean = sftpConnectionInfoBean;
		return this;
	}

	@Override
	public void handleFileModification(File modifiedFile) {
		THREAD_POOL_EXECUTOR.execute(SUBMITCHANGEDFILETHREAD.setCommand(new SubmitModifiedFileToSvnCommand(modifiedFile)));
		THREAD_POOL_EXECUTOR.execute(SUBMITCHANGEDFILETHREAD.setCommand(new UploadModifiedFileToServerCommand(new SFTPUtility(sftpConnectionInfoBean, modifiedFile).setWhetherToAutoCloseConnection(true))));
	}
}