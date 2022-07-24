package cn.kangyifan.factorymethod;

import cn.kangyifan.factorymethod.bean.Human;
import cn.kangyifan.factorymethod.bean.MaleBlackHuman;
import cn.kangyifan.factorymethod.bean.MaleWhiteHuman;
import cn.kangyifan.factorymethod.bean.MaleYellowHuman;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/14 21:43
 */
public class MaleFactory implements HumanFactory{

    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createBlackHuman() { return new MaleBlackHuman(); }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }
}
