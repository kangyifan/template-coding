package cn.kangyifan.factorymethod.bean;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/15 20:27
 */
public abstract class AbstractWhiteHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("White");
    }

    @Override
    public void talk() {
        System.out.println("White Human say:");
    }

    @Override
    public abstract void getSex();
}
