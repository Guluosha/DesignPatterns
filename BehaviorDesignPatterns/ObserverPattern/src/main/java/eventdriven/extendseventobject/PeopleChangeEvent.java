package eventdriven.extendseventobject;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/30 ~ 下午 5:52
 */

public interface PeopleChangeEvent {

	/**
	 * 任务改变事件发布者
	 * @param eventObject 事件对象
	 */
	void publishPeopleChangedEvent(Object eventObject);
}