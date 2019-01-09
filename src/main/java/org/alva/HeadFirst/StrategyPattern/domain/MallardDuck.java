package org.alva.HeadFirst.StrategyPattern.domain;

import org.alva.HeadFirst.StrategyPattern.Behavior.impl.FlyWithWings;
import org.alva.HeadFirst.StrategyPattern.Behavior.impl.Quack;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm MiniDuckSimulator");
    }
}
