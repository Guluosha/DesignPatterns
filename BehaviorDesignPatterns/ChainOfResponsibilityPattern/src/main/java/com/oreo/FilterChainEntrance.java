package com.oreo;

import com.oreo.concretefilter.FaceFilter;
import com.oreo.concretefilter.HTMLCustomFilterImpl;
import com.oreo.concretefilter.SensitiveFilter;
import com.oreo.messagewraper.RequestMessage;
import com.oreo.messagewraper.ResponseMessage;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/4/17 ~ 下午 3:21
 */

public class FilterChainEntrance {
	public static void main(String[] args) {
		String readyTobeProcessedString = "大家好 :),<script>,敏感,被就业,网络授课没感觉...";
		RequestMessage requestMessage = new RequestMessage();
		requestMessage.setMessage(readyTobeProcessedString);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage("Response");
		System.out.println("源数据为：\n" + readyTobeProcessedString);

		CustomFilterFilterChain cusFilterChain = new CustomFilterFilterChain();
		cusFilterChain.addFilter(new HTMLCustomFilterImpl()).addFilter(new SensitiveFilter()).addFilter(new FaceFilter());
		cusFilterChain.getAndDoFilter(requestMessage, responseMessage);

		System.out.println(requestMessage.getMessage());
		System.out.println(responseMessage.getMessage());
	}
}
