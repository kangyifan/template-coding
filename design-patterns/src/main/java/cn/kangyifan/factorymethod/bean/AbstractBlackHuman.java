package cn.kangyifan.factorymethod.bean;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/15 20:26
 */
public abstract class AbstractBlackHuman implements Human{

    @Override
    public void getColor() {
        System.out.println("Black");
    }

    @Override
    public void talk() {
        System.out.println("Black human say:");
    }

    @Override
    public abstract void getSex();
}
