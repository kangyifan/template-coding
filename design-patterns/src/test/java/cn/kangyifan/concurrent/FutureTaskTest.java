package cn.kangyifan.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/15 21:44
 */
public class FutureTaskTest {

    @Test
    void test() throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            throw new RuntimeException("1111");
        };
        FutureTask<Integer> futureTask = new FutureTask(runnable, 1);
        Thread thread = new Thread(futureTask);
        thread.start();
        int a = futureTask.get();
        System.out.printf(String.valueOf(a));
    }
}
