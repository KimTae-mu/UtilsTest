package org.alva.EntityValid;

import org.alva.EntityValid.accotation.entityvalid.EntityValidUtils;
import org.alva.EntityValid.accotation.entityvalid.ValidResult;
import org.junit.Test;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class EntityValidationExample {

    @Test
    public void testEntity() {
        TestEntity testEntity = new TestEntity();
        testEntity.setImage("from github");
        testEntity.setTitle("hello");
//        testEntity.setDesc("这是一段描述");

        ValidResult validate = EntityValidUtils.validate(testEntity);
        System.out.println(validate.getMessage());
        assert validate.isSucceed();
    }
}
