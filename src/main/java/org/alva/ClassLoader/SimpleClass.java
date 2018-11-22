package org.alva.ClassLoader;

import org.apache.log4j.pattern.LineSeparatorPatternConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class SimpleClass {

    private static byte[] buffer = new byte[8];

    private static String str = "";

    private static List<String> list = new ArrayList<>();

    static {
        buffer[0] = (byte) 1;
        str = "Simple";
        list.add("element");

        System.out.println(buffer[0]);
        System.out.println(str);
        System.out.println(list.get(0));
    }
}
