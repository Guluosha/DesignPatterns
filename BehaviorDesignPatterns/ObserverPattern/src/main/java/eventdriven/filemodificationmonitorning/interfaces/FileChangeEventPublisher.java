package eventdriven.filemodificationmonitorning.interfaces;

import java.io.File;
import java.util.EventListener;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/6/27 ~ 下午 10:48
 */

public interface FileChangeEventPublisher {

	/**
	 * 发布文件修改事件
	 *
	 * @param modifiedFile 修改的文件对象
	 */
	void publishFileChangeEvent(File modifiedFile);

	/**
	 * 注册文件监听器
	 *
	 * @param fileChangeListener 文件监听器对象
	 */
	void registryFileListeners(EventListener fileChangeListener);

	/**
	 * 注销文件监听器
	 *
	 * @param fileChangeListener 文件监听器对象
	 */
	void removeFileChangeListener(EventListener fileChangeListener);
}
