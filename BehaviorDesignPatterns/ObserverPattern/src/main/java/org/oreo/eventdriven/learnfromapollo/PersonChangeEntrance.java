package org.oreo.eventdriven.learnfromapollo;

import java.util.Scanner;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 * 人物改变事件入口
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/27 ~ 下午 7:49
 */

public class PersonChangeEntrance {

	public static void main(String[] args) {
		ConcretePersonContentChangeSource changeSource = new ConcretePersonContentChangeSource();
		changeSource.addPersonChangeListener(new ConcreteListener());
		do
		{
			Person inpputperson = receiveInputPersonContent();
			changeSource.onPersonContentChanged(inpputperson);
		}
		while (true);
	}

	private static Person receiveInputPersonContent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入人物信息，触发事件通知");
		System.out.println("输入人物姓名");
		String name = scanner.next();
		System.out.println("输入人物年龄");
		String age = scanner.next();
		System.out.println("输入人物性别");
		String sex = scanner.next();
		return new Person(name, age, sex);
	}
}