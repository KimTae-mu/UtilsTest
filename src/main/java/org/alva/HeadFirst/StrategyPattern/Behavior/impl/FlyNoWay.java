package org.alva.HeadFirst.StrategyPattern.Behavior.impl;

import org.alva.HeadFirst.StrategyPattern.Behavior.FlyBehavior;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
