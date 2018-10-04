package eventdriven.filemodificationmonitorning.workerthread.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/2 ~ 下午 2:09
 */

public class SubmitChangedFileThreadFactory implements ThreadFactory {

	private static final String THREADNAME = "ThreadOfCalculateFileMD5-Thread-";
	private volatile AtomicInteger threadSerialNumber = new AtomicInteger(0);

	@Override
	public Thread newThread(Runnable runnable) {
		System.out.println("新建线程：" + THREADNAME + threadSerialNumber.get());
		return new Thread(runnable, THREADNAME + threadSerialNumber.getAndIncrement());
	}
}