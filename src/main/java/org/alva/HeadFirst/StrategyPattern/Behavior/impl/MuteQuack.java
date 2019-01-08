package org.alva.HeadFirst.StrategyPattern.Behavior.impl;

import org.alva.HeadFirst.StrategyPattern.Behavior.QuackBehavior;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
