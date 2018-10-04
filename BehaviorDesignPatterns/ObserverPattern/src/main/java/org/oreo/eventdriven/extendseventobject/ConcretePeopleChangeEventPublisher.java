package org.oreo.eventdriven.extendseventobject;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/30 ~ 下午 6:09
 */

public class ConcretePeopleChangeEventPublisher extends AbstractPeopleChangeEventPublisher {

	private People people;

	public void setPeople(People people) {
		this.people = people;
	}

	public void onPeopleChanged(People people) {
		if (this.people != people) {
			if ((!this.people.getName().equals(people.getName())) || (!this.people.getAge().equals(people.getAge())) || (!this.people.getSex().equals(people.getSex()))) {
				notifyListeners(people);
				this.people = people;
			}
		}
	}

	private void notifyListeners(People people) {
		super.publishPeopleChangeEvent(people);
	}
}