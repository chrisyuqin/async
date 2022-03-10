package com.study.task;

import cn.hutool.core.date.DateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * @project: fssc-service-image
 * @ClassName: AsyncTask
 * @author: Qin Wei Chang
 * @creat: 2022/3/10 3:47 下午
 * 描述:AsyncTask
 */
// Component 将这个类加载到spring容器当中  Slf4j是springboot自带的日志框架
@Component
public class AsyncTask {

    // 生成一个随机数
    private static Random random = new Random();

    // 开启异步操作
    //@Async
    public String task(String aa) throws InterruptedException {
        System.out.println("开始做任务一"+Thread.currentThread().getName());
        System.out.println("传入参数="+aa);
        long start = System.currentTimeMillis();
        // 让这个线程睡眠，让测试效果更加的明显
        Thread.sleep(random.nextInt(100));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return aa+"task1";
    }
    // 开启异步操作
    @Async
    public void taskAsync1(String aa) throws Exception {
        System.out.println("开始执行异步任务二-"+Thread.currentThread().getName());
        System.out.println("传入参数="+aa);
        // 让这个线程睡眠，让测试效果更加的明显
        Thread.sleep(5000);
        for (int i = 0; i < 10; i++) {
            System.out.println("##########################" + i);
        }
        System.out.println("完成执行异步任务二");
        System.out.println(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss.sss"));
    }
}