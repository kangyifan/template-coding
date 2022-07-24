package cn.kangyifan.executor;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/4/2022 3:15 PM
 */
public class ExecutorDemo {

    @Test
    void name() {

        ConcurrentTaskExecutor executor = new ConcurrentTaskExecutor();
        ListenableFuture lf = executor.submitListenable(()->{
            System.out.println("1111");
        });
        lf.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println(result);
            }
        });
    }
}
