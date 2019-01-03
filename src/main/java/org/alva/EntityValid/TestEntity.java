package org.alva.EntityValid;

import org.alva.EntityValid.accotation.entityvalid.Valid;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class TestEntity {
    @Valid(description = "图片路径", isEmpty = false, minLength = 1)
    private String image;

    @Valid(description = "标题", isEmpty = false, maxLength = 20, minLength = 1)
    private String title;

    @Valid(description = "描述")
    private String desc;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
