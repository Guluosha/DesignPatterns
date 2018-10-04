package org.oreo.eventdriven.filemodificationmonitorning;

import org.oreo.eventdriven.filemodificationmonitorning.filters.*;
import org.oreo.eventdriven.filemodificationmonitorning.messagelisteners.*;
import org.oreo.eventdriven.filemodificationmonitorning.messagepublishers.*;
import org.oreo.eventdriven.filemodificationmonitorning.sftp.bean.*;

import java.util.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/6/30 ~ 下午 5:29
 */

public class FileMonitorEntrance {

	private static final String DELIMITER = ",";

	public static void main(String[] args) {
		ConcreteOptionHandlerChain concreteOptionHandlerChain = new ConcreteOptionHandlerChain();
		concreteOptionHandlerChain.addOptionHandler(new InputOptionHandler());
		Map<String, String> stringArguments = concreteOptionHandlerChain.handleOption(args, concreteOptionHandlerChain);
		String filePath = stringArguments.get("filepath");
		String[] paths = getPATHS(filePath);
		SFTPConnectionInfoBean sftpConnectionInfoBean = new SFTPConnectionInfoBean(stringArguments.get("ip"), stringArguments.get("port"), stringArguments.get("username"), stringArguments.get("password"), stringArguments.get("storepath"));
		ConcreteFileChangeEventPublisher concreteFileChangeEventPublisher = new ConcreteFileChangeEventPublisher();
		ConcreteFileChangeListener concreteFileChangeListener = new ConcreteFileChangeListener();
		concreteFileChangeEventPublisher.registryFileListeners(concreteFileChangeListener.setSftpConnectionInfoBean(sftpConnectionInfoBean));
		concreteFileChangeEventPublisher.publishFileChangedEvent(paths);
	}

	private static String[] getPATHS(String filePath) {
		if (filePath != null) {
			if (filePath.contains(DELIMITER)) {
				return filePath.split(DELIMITER);
			} else {
				String[] strings = new String[1];
				strings[0] = filePath;
				return strings;
			}
		}
		return new String[0];
	}
}