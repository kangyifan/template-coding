package cn.kangyifan.factorymethod.bean;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/15 20:32
 */
public class FemaleBlackHuman extends AbstractBlackHuman {

    @Override
    public void getSex() {
        System.out.println("females");
    }
}
