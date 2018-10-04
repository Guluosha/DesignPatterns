package uploadfile;

import org.oreo.eventdriven.filemodificationmonitorning.ftp.bean.*;
import org.oreo.eventdriven.filemodificationmonitorning.ftp.utils.*;

import java.io.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/12 ~ 上午 11:48
 */

public class TestUploadFile {


	public static void main(String[] args) {
		useFTPUploadFile();
	}

	private static void useFTPUploadFile() {
		FTPUtility ftpUtility = new FTPUtility();
		ftpUtility.initFTPConnection(new FTPConnectionInfoBean("10.11.61.39", "spdb", "spdb12345", "/home/spdb/testDirectory"));
		ftpUtility.setWhetherToAutoCloseConnection(true);
		ftpUtility.uploadFile(new File("D:\\ThirdpartyJar\\test.jar"));
	}

}