package org.oreo.eventdriven.extendseventobject;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/30 ~ 下午 5:42
 */

public class ConcretePeopleChangeEventListener implements PeopleChangeEventListener {

	@Override
	public void onPeopleChangeEvent(Object eventObject) {
		if (eventObject instanceof People) {
			System.out.println("对象属性被改变了，现在的属性为：");
			System.out.println("姓名：" + ((People) eventObject).getName());
			System.out.println("年龄：" + ((People) eventObject).getAge());
			System.out.println("性别：" + ((People) eventObject).getSex());
		}
	}
}
