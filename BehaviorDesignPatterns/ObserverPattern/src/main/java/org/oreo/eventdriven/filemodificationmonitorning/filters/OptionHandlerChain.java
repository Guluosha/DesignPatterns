package org.oreo.eventdriven.filemodificationmonitorning.filters;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/19 ~ 下午 5:30
 */

public interface OptionHandlerChain<T> {

	/**
	 * 添加选项处理器
	 *
	 * @param optionHandler 选项处理器
	 */
	void addOptionHandler(OptionHandler<T> optionHandler);

	/**
	 * 移除选项处理器
	 *
	 * @param optionHandler 选项处理器
	 */
	void removeOptionHandler(OptionHandler<T> optionHandler);

	/**
	 * 对传送进来的参数做处理，并返回值
	 *
	 * @param strings            待处理的对象数组
	 * @param optionHandlerChain 处理器链
	 * @return T，泛型结果
	 */
	T handleOption(String[] strings, OptionHandlerChain<T> optionHandlerChain);
}
