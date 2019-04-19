package org.oreo.eventdriven.filemodificationmonitorning.commands;

import org.oreo.eventdriven.filemodificationmonitorning.interfaces.*;

import java.io.*;
import java.util.concurrent.atomic.*;

/**
 * CopyRight (C),YLINK-深圳雁联计算有限公司
 *
 * @author 李沛恒(QQ ： 单曲循环)
 * @date 2018/7/4 ~ 下午 4:34
 */

public class SubmitModifiedFileToSvnCommand implements Command {

    /**
     * Runtime对象
     */
    private static Runtime RUNTIME = Runtime.getRuntime();
    /**
     * 登录到远程服务器的用户名
     */
    private static String username = "szfhcszyzh9";
    /**
     * 登录到远程服务器的用户密码
     */
    private static String password = "ylink54321";
    /**
     * 监控到的被修改的文件对象
     */
    private File modifiedFile;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取命令内容
     *
     * @return String，命令内容
     */
    private String getCommand() {
        /*return "cmd /c svn commit " + modifiedFile.getAbsolutePath() + " --username " + username + " --password " + password;*/
        return "cmd /c echo file:" + modifiedFile.getAbsolutePath() + " has been modified " + atomicInteger.getAndIncrement() + " times";
    }

    /**
     * 构造函数
     *
     * @param modifiedFile 监控到的被修改的文件
     */
    public SubmitModifiedFileToSvnCommand(File modifiedFile) {
        this.modifiedFile = modifiedFile;
    }

    /**
     * 执行本命令
     *
     * @return
     */
    @Override
    public String execute() {
        String result;
        try {
            Process executionResult = RUNTIME.exec(getCommand());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(executionResult.getInputStream()));
            while ((result = bufferedReader.readLine()) != null) {
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "执行异常";
    }
}