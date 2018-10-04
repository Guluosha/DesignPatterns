package eventdriven.filemodificationmonitorning.commands;

import eventdriven.filemodificationmonitorning.ftp.utils.FTPUtility;
import eventdriven.filemodificationmonitorning.interfaces.Command;
import eventdriven.filemodificationmonitorning.sftp.utils.SFTPUtility;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 * <br/>
 * 命令 -- 上传文件到服务器
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/12 ~ 上午 11:18
 */

public class UploadModifiedFileToServerCommand implements Command {

	private SFTPUtility sftpUtility;
	private FTPUtility ftpUtility;

	public UploadModifiedFileToServerCommand(SFTPUtility sftpUtility) {
		this.sftpUtility = sftpUtility;
	}

	public UploadModifiedFileToServerCommand(FTPUtility ftpUtility) {
		this.ftpUtility = ftpUtility;
	}

	@Override
	public String execute() {
		sftpUtility.uploadFile();
		return "处理完毕";
	}
}