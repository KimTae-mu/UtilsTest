package org.alva.Test;

import java.util.Scanner;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class StrReverse {

    static char[] reverse(char[] value) {
        // TODO
        char[] temp = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            temp[i] = value[temp.length - i - 1];

        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.print(new String(reverse(str.toCharArray())));
    }
}
