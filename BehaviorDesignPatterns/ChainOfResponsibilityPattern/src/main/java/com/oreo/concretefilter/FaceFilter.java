package com.oreo.concretefilter;

import com.oreo.CustomFilter;
import com.oreo.CustomFilterFilterChain;
import com.oreo.messagewraper.RequestMessage;
import com.oreo.messagewraper.ResponseMessage;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/4/17 ~ 下午 2:50
 */

public class FaceFilter implements CustomFilter {

	@Override
	public void doFilter(RequestMessage requestMessage, ResponseMessage responseMessage, CustomFilterFilterChain cusFilterChain) {
		String replacedMessage = requestMessage.getMessage().replace(":)", "笑脸");
		requestMessage.setMessage(replacedMessage);
		cusFilterChain.getAndDoFilter(requestMessage, responseMessage);
		responseMessage.setMessage(responseMessage.getMessage() + "------>FaceFilter");
	}
}
