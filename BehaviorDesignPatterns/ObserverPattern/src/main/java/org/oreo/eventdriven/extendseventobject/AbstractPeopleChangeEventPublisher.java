package org.oreo.eventdriven.extendseventobject;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Set;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 * 抽象人物改变事件发布者（广播者）
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/30 ~ 下午 5:57
 */

public abstract class AbstractPeopleChangeEventPublisher implements PeopleChangeEventPublisher {

	private static final Set<EventListener> LISTENERS = new HashSet<>();

	protected void registerPeopleChangeEventListener(EventListener listener) {
		if (!LISTENERS.contains(listener)) {
			LISTENERS.add(listener);
		}
	}

	protected void removePeopleChangeEventListener(EventListener listener) {
		if (LISTENERS.contains(listener)) {
			LISTENERS.remove(listener);
		}
	}

	@Override
	public void publishPeopleChangeEvent(Object eventObject) {
		for (EventListener listener : LISTENERS) {
			if (listener instanceof PeopleChangeEventListener) {
				((PeopleChangeEventListener) listener).onPeopleChangeEvent(eventObject);
			}
		}
	}
}