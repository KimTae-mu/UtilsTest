package org.alva.HeadFirst.StrategyPattern.domain;

import org.alva.HeadFirst.StrategyPattern.Behavior.FlyBehavior;
import org.alva.HeadFirst.StrategyPattern.Behavior.QuackBehavior;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float,even decoys");
    }
}
