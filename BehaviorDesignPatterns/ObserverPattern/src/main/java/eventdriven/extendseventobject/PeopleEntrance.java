package eventdriven.extendseventobject;

import java.util.Scanner;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/30 ~ 下午 9:00
 */

public class PeopleEntrance {


	public static void main(String[] args) {
		PeopleEntrance peopleEntrance = new PeopleEntrance();
		ConcretePeopleChangeEvent peopleChangeEvent = peopleEntrance.init();
		do
		{
			People inputPeople = peopleEntrance.receiveInputPersonContent();
			peopleChangeEvent.onPeopleChanged(inputPeople);
		}
		while (true);
	}

	private People receiveInputPersonContent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入人物信息，触发事件通知");
		System.out.println("输入人物姓名");
		String name = scanner.next();
		System.out.println("输入人物年龄");
		String age = scanner.next();
		System.out.println("输入人物性别");
		String sex = scanner.next();
		return new People(this, name, age, sex);
	}

	private ConcretePeopleChangeEvent init() {
		People people = new People(this, "asd", "asd", "asd");
		ConcretePeopleChangeEvent peopleChangeEvent = new ConcretePeopleChangeEvent();
		peopleChangeEvent.registerListener(new ConcretePeopleChangeListener());
		peopleChangeEvent.setPeople(people);
		return peopleChangeEvent;
	}
}
