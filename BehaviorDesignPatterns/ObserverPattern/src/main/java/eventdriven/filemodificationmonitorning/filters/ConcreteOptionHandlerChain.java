package eventdriven.filemodificationmonitorning.filters;

import java.util.Map;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/20 ~ 下午 3:06
 */

public class ConcreteOptionHandlerChain extends AbstractOptionHandlerChain {

	@Override
	public Map<String, String> handleOption(String[] strings, OptionHandlerChain<Map<String, String>> optionHandlerChain) {
		return super.handleOption(strings, optionHandlerChain);
	}
}
