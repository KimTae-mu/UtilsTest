package org.alva.HeadFirst.StrategyPattern;

import org.alva.HeadFirst.StrategyPattern.domain.Duck;
import org.alva.HeadFirst.StrategyPattern.domain.MallardDuck;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
    }
}
