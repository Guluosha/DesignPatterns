package org.oreo.eventdriven.filemodificationmonitorning.optionenum;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/19 ~ 下午 5:09
 */

public enum Option {

	/**
	 * IP地址
	 */
	ip("ip"),

	/**
	 * 端口号
	 */
	port("port"),

	/**
	 * 文件类型
	 */
	filetype("filetype"),

	/**
	 * 文件所在目录
	 */
	filepath("filepath"),

	/**
	 * 用户名
	 */
	username("username"),

	/**
	 * 用户密码
	 */
	password("password"),

	/**
	 * 上传路径
	 */
	storepath("storepath");

	private String name;

	Option(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
