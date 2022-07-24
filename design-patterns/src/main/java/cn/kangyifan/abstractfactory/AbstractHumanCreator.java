package cn.kangyifan.abstractfactory;

import cn.kangyifan.factorymethod.bean.Human;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/15 20:50
 */
public abstract class AbstractHumanCreator {

    public abstract Human createMan();

    public abstract Human createFemale();
}
