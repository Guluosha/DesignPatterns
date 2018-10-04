import java.io.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/5/16 ~ 上午 11:52
 */

public class ToKnowJDKIO {
	private static final String FILEPATH = "D:\\Log4j\\isp-bots-stm";

	public static void main(String[] args) {
		try {
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(FILEPATH + "\\stm-log"));
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FILEPATH + "\\stm-log"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}