package eventdriven.filemodificationmonitorning.filters;

import java.util.HashMap;
import java.util.Map;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/19 ~ 下午 7:20
 */

public class InputOptionHandler implements OptionHandler<Map<String, String>> {

	@Override
	public Map<String, String> handleOptions(String[] strings) {
		Map<String, String> tempMap = new HashMap<>(6);
		for (String stringArgument : strings) {
			String replacedString = stringArgument.replace("--", "");
			System.out.println(replacedString);
			String[] optionAndValue = replacedString.split("=");
			switch (optionAndValue[0]) {
				case "filepath":
					tempMap.put("filepath", optionAndValue[1]);
					continue;
				case "storepath":
					tempMap.put("storepath", optionAndValue[1]);
					continue;
				case "username":
					tempMap.put("username", optionAndValue[1]);
					continue;
				case "password":
					tempMap.put("password", optionAndValue[1]);
					continue;
				case "ip":
					tempMap.put("ip", optionAndValue[1]);
					continue;
				case "port":
					tempMap.put("port", optionAndValue[1]);
					continue;
				default:
					System.out.println("参数不符合要求");
					return null;
			}
		}
		System.out.println("选项参数=" + tempMap);
		return tempMap;
	}
}