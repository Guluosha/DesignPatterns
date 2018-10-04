package eventdriven.filemodificationmonitorning.messagelisteners;

import eventdriven.filemodificationmonitorning.commands.SubmitModifiedFileToSvnCommand;
import eventdriven.filemodificationmonitorning.commands.UploadModifiedFileToServerCommand;
import eventdriven.filemodificationmonitorning.interfaces.AbstractFileChangeListener;
import eventdriven.filemodificationmonitorning.sftp.bean.SFTPConnectionInfoBean;
import eventdriven.filemodificationmonitorning.sftp.utils.SFTPUtility;
import eventdriven.filemodificationmonitorning.workerthread.SubmitChangedFileThread;

import java.io.File;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/6/27 ~ 下午 11:37
 */

public class ConcreteFileChangeListener extends AbstractFileChangeListener {

	private SFTPConnectionInfoBean sftpConnectionInfoBean;
	private static SubmitChangedFileThread SUBMITCHANGEDFILETHREAD = new SubmitChangedFileThread();
//	private SFTPConnectionInfoBean sftpConnectionInfoBean = new SFTPConnectionInfoBean("10.11.61.39", "22", "spdb", "spdb12345", "");

	public ConcreteFileChangeListener setSftpConnectionInfoBean(SFTPConnectionInfoBean sftpConnectionInfoBean) {
		this.sftpConnectionInfoBean = sftpConnectionInfoBean;
		return this;
	}

	@Override
	public void handleFileModification(File modifiedFile) {
		THREAD_POOL_EXECUTOR.execute(SUBMITCHANGEDFILETHREAD.setCommand(new SubmitModifiedFileToSvnCommand(modifiedFile)));
		THREAD_POOL_EXECUTOR.execute(SUBMITCHANGEDFILETHREAD.setCommand(new UploadModifiedFileToServerCommand(new SFTPUtility(sftpConnectionInfoBean, modifiedFile).setWhetherToAutoCloseConnection(true))));
	}
}