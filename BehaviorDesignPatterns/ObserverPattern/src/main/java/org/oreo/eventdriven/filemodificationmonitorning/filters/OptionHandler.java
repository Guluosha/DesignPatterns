package org.oreo.eventdriven.filemodificationmonitorning.filters;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/19 ~ 下午 5:28
 */

public interface OptionHandler<T> {

	/**
	 * 对传进来的对象数组做处理
	 *
	 * @param strings 对象数组
	 * @return T，泛型结果
	 */
	T handleOptions(String[] strings);
}
