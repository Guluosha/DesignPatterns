package org.oreo.eventdriven.extendseventobject;

import java.util.EventListener;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/29 ~ 下午 10:09
 */

public interface PeopleChangeListener extends EventListener {

	void onPeopleChangeEvent(Object eventObject);
}
