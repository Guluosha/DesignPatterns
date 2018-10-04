package org.oreo.eventdriven.filemodificationmonitorning.interfaces;

import org.oreo.eventdriven.filemodificationmonitorning.workerthread.factory.*;

import java.io.*;
import java.util.concurrent.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/4 ~ 下午 3:31
 */

public abstract class AbstractFileChangeEventListener implements FileChangeEventListener {

	protected static ThreadPoolExecutor THREAD_POOL_EXECUTOR;

	static {
		int coreThreads = Runtime.getRuntime().availableProcessors();
		int maximumThreads = coreThreads << 1;
		long threadLeisureTime = 2L;
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(maximumThreads);
		THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(coreThreads, maximumThreads, threadLeisureTime, TimeUnit.SECONDS, blockingQueue, new SubmitChangedFileThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
	}

	/**
	 * 具体如何处理文件交由子类去实现
	 *
	 * @param modifiedFile 监听对象
	 */
	@Override
	public abstract void handleFileModification(File modifiedFile);
}