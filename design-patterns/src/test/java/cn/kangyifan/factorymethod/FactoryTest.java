package cn.kangyifan.factorymethod;

import cn.kangyifan.factorymethod.bean.Human;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 2022/5/15 20:37
 */
public class FactoryTest {

    public static void main(String[] arsgs) {
        HumanFactory factory1 = new FemaleFactory();
        invoke(factory1::createBlackHuman);
        invoke(factory1::createWhiteHuman);
        invoke(factory1::createYellowHuman);
        HumanFactory factory2 = new MaleFactory();
        invoke(factory2::createBlackHuman);
        invoke(factory2::createWhiteHuman);
        invoke(factory2::createYellowHuman);
    }


    public static void invoke(Supplier<Human> humanSupplier) {
        Human human = humanSupplier.get();
        human.getColor();
        human.getSex();
        human.talk();
        System.out.printf("\n");
    }
}