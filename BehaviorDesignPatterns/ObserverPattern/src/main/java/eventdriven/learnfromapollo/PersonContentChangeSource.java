package eventdriven.learnfromapollo;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/25 ~ 下午 4:55
 */

public interface PersonContentChangeSource {

	void addPersonChangeListener(PersonChangeListener personChangeListener);

	void removePersonChangeListener(PersonChangeListener personChangeListener);

	void notifyAllPersonChangeListener(Person person);
}
