package com.uniubi.visitor.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zqp
 */
public class ThreadPoolUtils implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolUtils.class);

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(15, 50, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(2000),
            ((r, executor) -> logger.error("ThreadPoolUtils error")));


    public static ThreadPoolExecutor getThreadPools(){
        return threadPoolExecutor;
    }
}
