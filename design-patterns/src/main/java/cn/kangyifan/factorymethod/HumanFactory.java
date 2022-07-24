package cn.kangyifan.factorymethod;

import cn.kangyifan.factorymethod.bean.Human;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/15 20:34
 */
public interface HumanFactory {
    Human createYellowHuman();

    Human createBlackHuman();

    Human createWhiteHuman();
}
