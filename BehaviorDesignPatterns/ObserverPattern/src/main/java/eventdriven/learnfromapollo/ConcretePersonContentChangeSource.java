package eventdriven.learnfromapollo;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/25 ~ 下午 5:13
 */

public class ConcretePersonContentChangeSource extends AbstractPersonContentChange {

	private Person oldPerson = new Person("default", "default", "default");

	public void onPersonContentChanged(Person newperson) {
		if ((!oldPerson.getName().equals(newperson.getName())) || (!oldPerson.getAge().equals(newperson.getAge())) || (!oldPerson.getSex().equals(newperson.getSex()))) {
			super.notifyAllPersonChangeListener(newperson);
			oldPerson = newperson;
		}
	}
}