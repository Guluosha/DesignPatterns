package org.oreo.eventdriven.learnfromapollo;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 * 人物类
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/25 ~ 下午 4:48
 */

public class Person {

	private String name;
	private String age;
	private String sex;

	public Person(String name, String age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}