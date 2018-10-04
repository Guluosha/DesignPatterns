package com.oreo;

import com.oreo.messagewraper.CustomFilterChain;
import com.oreo.messagewraper.RequestMessage;
import com.oreo.messagewraper.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/4/17 ~ 下午 2:46
 */

public class CustomFilterFilterChain implements CustomFilterChain {
	private List<CustomFilter> customFilterList = new ArrayList<>();
	private int index = 0;

	@Override
	public CustomFilterChain addFilter(CustomFilter customFilter) {
		if (!customFilterList.contains(customFilter)) {
			customFilterList.add(customFilter);
		}
		return this;
	}

	@Override
	public void getAndDoFilter(RequestMessage requestMessage, ResponseMessage responseMessage) {
		if (index == customFilterList.size()) {
			System.out.println("已处理完");
		} else {
			index++;
			CustomFilter nextFilter = customFilterList.get(index - 1);
			nextFilter.doFilter(requestMessage, responseMessage, this);
		}
	}
}