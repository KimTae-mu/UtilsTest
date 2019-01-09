package org.alva.Test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class StringTest {

    @Test
    public void SpecialCharactersTest(){
        String str = "8!@#$%^&*()gjkf{}:,./<>";
        System.out.println(str);
    }

    @Test
    public void SubStringTest(){
        String str = "部门1|部门2|部门3";
        str = str.substring(str.lastIndexOf("|")+1);
        System.out.println(str);
    }
}
