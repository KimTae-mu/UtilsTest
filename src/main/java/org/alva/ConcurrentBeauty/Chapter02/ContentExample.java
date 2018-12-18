package org.alva.ConcurrentBeauty.Chapter02;

import org.junit.Test;

import java.awt.*;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ContentExample {

    static final int LINE_NUM = 1024;
    static final int COLUM_NUM = 1024;

    @Test
    public void Cache() {
        long[][] array = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUM_NUM; j++) {
                array[i][j] = i * 2 + j;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("cache Time :" + (endTime - startTime));
    }

    @Test
    public void noCache() {
        long[][] array = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COLUM_NUM; i++) {
            for (int j = 0; j < LINE_NUM; j++) {
                array[j][i] = i * 2 + j;
            }
        }

        System.out.println("no Cache TIme : " + (System.currentTimeMillis() - startTime));
    }
}
