package org.oreo.eventdriven.filemodificationmonitorning.workerthread;

import org.oreo.eventdriven.filemodificationmonitorning.interfaces.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/3 ~ 上午 10:07
 */

public class SubmitChangedFileThread implements Runnable {

	private Command command;

	public SubmitChangedFileThread() {
	}

	public SubmitChangedFileThread setCommand(Command command) {
		this.command = command;
		return this;
	}

	@Override
	public void run() {
		String executionResult = command.execute();
		System.out.println(executionResult);
	}
}