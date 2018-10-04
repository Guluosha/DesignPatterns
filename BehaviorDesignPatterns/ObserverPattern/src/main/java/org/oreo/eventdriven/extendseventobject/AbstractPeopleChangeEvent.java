package org.oreo.eventdriven.extendseventobject;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Set;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/30 ~ 下午 5:57
 */

public abstract class AbstractPeopleChangeEvent implements PeopleChangeEvent {

	private static final Set<EventListener> LISTENERS = new HashSet<>();

	protected void registerListener(EventListener listener) {
		if (!LISTENERS.contains(listener)) {
			LISTENERS.add(listener);
		}
	}

	protected void removeListener(EventListener listener) {
		if (LISTENERS.contains(listener)) {
			LISTENERS.remove(listener);
		}
	}

	@Override
	public void publishPeopleChangedEvent(Object eventObject) {
		for (EventListener listener : LISTENERS) {
			if (listener instanceof PeopleChangeListener) {
				((PeopleChangeListener) listener).onPeopleChangeEvent(eventObject);
			}
		}
	}
}