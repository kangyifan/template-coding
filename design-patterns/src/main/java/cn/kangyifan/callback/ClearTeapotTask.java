package cn.kangyifan.callback;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/16 20:45
 */
public class ClearTeapotTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":洗茶壶");
    }
}
