package com.oreo;

import com.oreo.messagewraper.RequestMessage;
import com.oreo.messagewraper.ResponseMessage;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/4/17 ~ 下午 2:45
 */

public interface CustomFilter {

	/**
	 * 一般维护后继链有两种方式：1.在接口中指定使用的后继链；2.由具体的处理者来指定下一个处理者（但是这种方式比较麻烦，耦合性较高，推荐前者方式）
	 *
	 * @param requestMessage  请求
	 * @param responseMessage 返回
	 * @param cusFilterChain  后继链
	 */
	void doFilter(RequestMessage requestMessage, ResponseMessage responseMessage, CustomFilterFilterChain cusFilterChain);
}
