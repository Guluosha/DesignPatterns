package eventdriven.learnfromapollo;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/27 ~ 下午 7:00
 */

public class ConcreteListener implements PersonChangeListener {

	@Override
	public void onPersonContentChange(Person person) {
		if (person != null) {
			System.out.println("现在的名字为：" + person.getName());
			System.out.println("现在的年龄为：" + person.getAge());
			System.out.println("现在的性别为：" + person.getSex());
		}
	}
}
