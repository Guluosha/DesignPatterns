package eventdriven.filemodificationmonitorning.interfaces;

import java.io.File;
import java.util.EventListener;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/6/27 ~ 下午 10:47
 */

public interface FileChangeListener extends EventListener{

	/**
	 * 监听文件，若文件变动，则触发此方法的调用
	 *
	 * @param modifiedFile 监听对象
	 */
	void handleFileModification(File modifiedFile);

}
