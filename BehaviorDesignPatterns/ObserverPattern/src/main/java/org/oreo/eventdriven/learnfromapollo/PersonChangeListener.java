package org.oreo.eventdriven.learnfromapollo;

import java.util.EventListener;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 * 人物监听器
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/25 ~ 下午 4:48
 */

public interface PersonChangeListener extends EventListener {

	/**
	 * 在人物内容改变时，监听器的操作
	 *
	 * @param person 监听对象
	 */
	void onPersonContentChange(Person person);
}
