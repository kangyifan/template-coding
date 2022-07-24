package cn.kangyifan.callback;

import com.google.common.util.concurrent.*;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/16 20:52
 */
public class BoilWaterCallbackTest {



    public static void main(String[] args) {

        FutureTask futureTask = new FutureTask(Executors.callable(()-> {
            System.out.printf("111");
        }, true));

        Thread t1 = new Thread(futureTask);
        t1.start();

        CompletableFuture.

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        ListeningExecutorService gPool = MoreExecutors.listeningDecorator(executorService);
//        ListenableFuture<Integer> clearCupFuture = gPool.submit(new ClearCupTask(), 1);
//
//        Futures.addCallback(clearCupFuture, new FutureCallback<Integer>() {
//            @Override
//            public void onSuccess(@Nullable Integer result) {
//                ListenableFuture<Integer> clearTeapotFuture = gPool.submit(new ClearTeapotTask(), 1);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                System.out.printf(t.getMessage());
//            }
//        }, executorService);
//
//        gPool.shutdown();

    }
}
