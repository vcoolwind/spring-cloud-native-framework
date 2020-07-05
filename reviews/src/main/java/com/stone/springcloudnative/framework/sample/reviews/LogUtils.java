package com.stone.springcloudnative.framework.sample.reviews;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();


    /**
     * 获取制定包的日志级别
     *
     * @param packageName 包名
     * @return String               日志级别
     */
    public static String getLevel(String packageName) {
        Logger logger = loggerContext.getLogger(packageName);
        return logger.getLevel().toString();
    }

    /**
     * 设置制定包的日志级别
     *
     * @param packageName 包名
     * @param level       日志等级
     */
    public static void setLevel(String packageName, String level) {
        loggerContext.getLogger(packageName).setLevel(Level.toLevel(level));
    }


}
