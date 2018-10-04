package org.oreo.eventdriven.filemodificationmonitorning.interfaces;

import java.io.*;
import java.util.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/6/27 ~ 下午 11:03
 *
 */

public abstract class AbstractFileChangeEventPublisher implements FileChangeEventPublisher {

	private static int DEFAULTLISTENERS = 8;
	private List<EventListener> listeners = new ArrayList<>(DEFAULTLISTENERS);

	@Override
	public void publishFileChangeEvent(File modifiedFile) {
		for (EventListener listener : listeners) {
			if (listener instanceof FileChangeListener) {
				((FileChangeListener) listener).handleFileModification(modifiedFile);
			}
		}
	}

	@Override
	public void registryFileListeners(EventListener fileChangeListener) {
		if (fileChangeListener instanceof FileChangeListener) {
			if (!listeners.contains(fileChangeListener)) {
				listeners.add(fileChangeListener);
			}
		}
	}

	@Override
	public void removeFileChangeListener(EventListener fileChangeListener) {
		if (fileChangeListener instanceof FileChangeListener) {
			if (listeners.contains(fileChangeListener)) {
				listeners.remove(fileChangeListener);
			}
		}
	}
}