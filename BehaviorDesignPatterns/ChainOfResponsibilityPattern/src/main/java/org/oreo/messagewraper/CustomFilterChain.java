package org.oreo.messagewraper;

import org.oreo.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/31 ~ 下午 6:14
 */

public interface CustomFilterChain {

	/**
	 * 添加过滤器
	 * @param customFilter 自定义过滤器
	 * @return CustomFilterChain，下一个过滤链节点
	 */
	CustomFilterChain addFilter(CustomFilter customFilter);

	/**
	 * 获取过滤链节点中的过滤器并对入参做处理
	 * @param requestMessage 请求参数
	 * @param responseMessage 响应参数
	 */
	void getAndDoFilter(RequestMessage requestMessage, ResponseMessage responseMessage);
}
