package org.cheng.tasks;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cheng
 *         2018/4/27 21:57
 */
@Component
public class TestTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定义每过 3s 执行任务
     */
    // @Scheduled(fixedRate = 3000)
    // 4-40秒 每过一秒执行任务
    // @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime() {
        System.out.println("现在时间： " + DATE_FORMAT.format(new Date()));
    }
}
