package org.oreo.eventdriven.learnfromapollo;

import java.util.HashSet;
import java.util.Set;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 * 抽象人物改变事件源
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/25 ~ 下午 4:59
 */

public abstract class AbstractPersonContentChange implements PersonContentChangeSource {

	protected static final Set<PersonChangeListener> LISTENERS = new HashSet<>();

	@Override
	public void addPersonChangeListener(PersonChangeListener personChangeListener) {
		if (!LISTENERS.contains(personChangeListener) && personChangeListener != null) {
			LISTENERS.add(personChangeListener);
		}
	}

	@Override
	public void removePersonChangeListener(PersonChangeListener personChangeListener) {
		if (!LISTENERS.isEmpty() && LISTENERS.contains(personChangeListener)) {
			LISTENERS.remove(personChangeListener);
		}
	}

	@Override
	public void notifyAllPersonChangeListener(Person person) {
		if (!LISTENERS.isEmpty()) {
			for (PersonChangeListener listener : LISTENERS) {
				listener.onPersonContentChange(person);
			}
		}
	}
}