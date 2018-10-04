package eventdriven.extendseventobject;

import java.util.EventObject;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/29 ~ 下午 10:08
 */

public class People extends EventObject {
	private String name;
	private String age;
	private String sex;

	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source The object on which the Event initially occurred.
	 * @throws IllegalArgumentException if source is null.
	 */
	public People(Object source, String name, String age, String sex) {
		super(source);
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public People getPeople() {
		return (People) getSource();
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
