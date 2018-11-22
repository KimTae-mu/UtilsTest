package org.alva.Test;

import org.alva.Utils.DateUtil;
import org.junit.Test;

import java.util.*;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class YearmoTest {
    public static void main(String[] args) {
        String yearmo = "201808";
        /*yearmo += "hello-";
        yearmo = yearmo.substring(0, yearmo.length() - 1);*/
//        String[] split = yearmo.split("-");

        String yearmoByInterval = DateUtil.getYearmoByInterval(yearmo, 5);

        System.out.println(yearmoByInterval);
    }

    @Test
    public void testBefore(){
        Integer yearmo = Integer.valueOf("201805");
        Date dateByYearmo = DateUtil.getDateByYearmo(yearmo);
        System.out.println(dateByYearmo.before(dateByYearmo));

    }

    @Test
    public void testFirstDayOfWeek(){
        System.out.println(DateUtil.getFirstDayOfWeek(new Date()));
        System.out.println(DateUtil.getBeginDayOfWeek());
    }
}
