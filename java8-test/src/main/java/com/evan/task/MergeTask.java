package com.evan.task;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/7/2022 3:46 PM
 */
public class MergeTask {

    public static void main(String[] args) {
        Long[] val = LongStream.range(1,10000).boxed().toArray(Long[]::new);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask myTask = new MyTask(val, 0, val.length);
        forkJoinPool.submit(myTask);
        try {
            long v = myTask.get();
            System.out.println(v);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyTask extends RecursiveTask<Long>{

        private final Long[] taskIds;
        private final int startInclude;
        private final int endExclude;

        private MyTask(Long[] taskIds, int startInclude, int endExclude){
            this.taskIds = taskIds;
            this.startInclude = startInclude;
            this.endExclude = endExclude;
        };

        private static final int MIN_SIZE = 1000;

        @Override
        protected Long compute() {
            int length = endExclude - startInclude;
            if(length <= MIN_SIZE){
                return calculate();
            }

            MyTask left = new MyTask(taskIds, startInclude, startInclude + length / 2);
            ForkJoinTask<Long> task1 = left.fork();

            MyTask right = new MyTask(taskIds, startInclude + length / 2, endExclude);
            ForkJoinTask<Long> task2 = right.fork();
            return task1.join() + task2.join();
        }

        public Long calculate(){
           return Arrays.stream(taskIds).mapToLong(t->t.longValue()).sum();
        }
    }
}
