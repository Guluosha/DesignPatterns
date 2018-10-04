package org.oreo.eventdriven.filemodificationmonitorning.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/19 ~ 下午 5:54
 */

public abstract class AbstractOptionHandlerChain implements OptionHandlerChain<Map<String, String>> {

	private List<OptionHandler<Map<String, String>>> optionHandlers = new ArrayList<>();

	@Override
	public void addOptionHandler(OptionHandler<Map<String, String>> optionHandler) {
		if (optionHandlers != null && !optionHandlers.contains(optionHandler)) {
			optionHandlers.add(optionHandler);
		}
	}

	@Override
	public void removeOptionHandler(OptionHandler<Map<String, String>> optionHandler) {
		if (optionHandlers != null && optionHandlers.contains(optionHandler)) {
			optionHandlers.remove(optionHandler);
		}
	}

	@Override
	public Map<String, String> handleOption(String[] strings, OptionHandlerChain<Map<String, String>> optionHandlerChain) {
		if (strings != null && !optionHandlers.isEmpty()) {
			for (OptionHandler<Map<String, String>> optionHandler : optionHandlers) {
				return optionHandler.handleOptions(strings);
			}
		}
		return null;
	}
}