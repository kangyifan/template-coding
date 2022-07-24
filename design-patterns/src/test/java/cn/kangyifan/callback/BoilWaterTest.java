package cn.kangyifan.callback;

import java.io.IOException;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/16 20:52
 */
public class BoilWaterTest {
    private static volatile boolean isComplete = false;
    
    public static void main(String[] args) throws IOException {

        Thread t1 = new Thread("清洗-线程"){
            @Override
            public void run() {
                new ClearCupTask().run();
                new ClearTeapotTask().run();
                isComplete = true;
            }
        };

        Thread t2 = new Thread("烧水-线程"){
            @Override
            public void run() {
                while (true) {
                    if(isComplete) {
                        new BoilWaterTask().run();
                        break;
                    }
                }
            }
        };
        t1.start();
        t2.start();
        System.in.read();
    }
}
