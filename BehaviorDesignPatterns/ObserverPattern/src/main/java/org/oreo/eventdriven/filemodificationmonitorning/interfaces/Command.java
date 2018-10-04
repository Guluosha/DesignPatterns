package org.oreo.eventdriven.filemodificationmonitorning.interfaces;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/3 ~ 上午 9:47
 */

public interface Command {

	/**
	 * 子类实现本方法
	 *
	 * @return 执行结果
	 */
	String execute();
}
