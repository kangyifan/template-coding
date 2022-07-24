package cn.kangyifan.factorymethod;

import cn.kangyifan.factorymethod.bean.FemaleBlackHuman;
import cn.kangyifan.factorymethod.bean.FemaleWhiteHuman;
import cn.kangyifan.factorymethod.bean.FemaleYellowHuman;
import cn.kangyifan.factorymethod.bean.Human;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/14 21:43
 */
public class FemaleFactory implements HumanFactory{

    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }
}
