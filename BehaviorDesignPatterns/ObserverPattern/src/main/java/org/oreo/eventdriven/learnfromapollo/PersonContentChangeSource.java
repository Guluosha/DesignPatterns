package org.oreo.eventdriven.learnfromapollo;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 * 人物改变事件源
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/25 ~ 下午 4:55
 */

public interface PersonContentChangeSource {

	/**
	 * 添加人物改变监听器
	 *
	 * @param personChangeListener 人物改变监听器对象
	 */
	void addPersonChangeListener(PersonChangeListener personChangeListener);

	/**
	 * 移除人物改变监听器
	 *
	 * @param personChangeListener 人物改变监听器
	 */
	void removePersonChangeListener(PersonChangeListener personChangeListener);

	/**
	 * 通知所有的人物监听器
	 *
	 * @param person 人物对象
	 */
	void notifyAllPersonChangeListener(Person person);
}
