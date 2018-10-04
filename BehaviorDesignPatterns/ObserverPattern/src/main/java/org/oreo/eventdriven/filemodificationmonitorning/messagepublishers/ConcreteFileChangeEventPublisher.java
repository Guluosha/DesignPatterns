package org.oreo.eventdriven.filemodificationmonitorning.messagepublishers;

import eventdriven.filemodificationmonitorning.interfaces.AbstractFileChangeEventPublisher;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/6/27 ~ 下午 11:30
 */

public class ConcreteFileChangeEventPublisher extends AbstractFileChangeEventPublisher {

	private String filePostfix = ".jar";
	private static WatchService WATCH_SERVICE;

	static {
		try {
			WATCH_SERVICE = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取路径下的文件
	 *
	 * @param filePath 文件路径
	 * @return File，该路径下的文件
	 */
	private File getFile(String filePath) {
		File tempFileObject = new File(filePath);
		if (tempFileObject.isDirectory()) {
			File[] files = tempFileObject.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						return file;
					}
				}
			}
		}
		return tempFileObject;
	}

	/**
	 * 注册需要监听的文件状态
	 *
	 * @param filePaths 多个目录（文件夹）
	 * @return String，目录（文件夹）的绝对路径
	 */
	private String registryFileStatus(String[] filePaths) {
		for (String filePath : filePaths) {
			File tempFile = new File(filePath);
			if (tempFile.isDirectory()) {
				try {
					System.out.println("获取待监控的目录：" + filePath);
					Path monitoredDirectory = FileSystems.getDefault().getPath(tempFile.getAbsolutePath());
					monitoredDirectory.register(WATCH_SERVICE, StandardWatchEventKinds.ENTRY_MODIFY);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 发布“文件被修改”事件
	 *
	 * @param filePaths 多个目录（文件夹）
	 */
	public void publishFileChangedEvent(String[] filePaths) {
		if (filePaths == null || filePaths.length == 0) {
			System.out.println("监听路径为空，请重新指定");
			return;
		}
		String filPath = registryFileStatus(filePaths);
		while (true) {
			try {
				WatchKey fileEventKey = WATCH_SERVICE.take();
				for (WatchEvent<?> watchEvent : fileEventKey.pollEvents()) {
					if (watchEvent.kind().name().equals(StandardWatchEventKinds.ENTRY_MODIFY.name())) {
						String nameOfModifiedFileOrDirectory = watchEvent.context().toString();
						File modifiedObject = new File(filPath + "\\" + nameOfModifiedFileOrDirectory);
						if (modifiedObject.isFile() && modifiedObject.getName().endsWith(filePostfix)) {
							super.publishFileChangeEvent(modifiedObject);
						}
					}
				}
				fileEventKey.reset();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}