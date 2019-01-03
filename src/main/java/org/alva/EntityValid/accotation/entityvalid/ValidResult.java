package org.alva.EntityValid.accotation.entityvalid;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ValidResult {

    /**
     * 验证结果
     */
    private boolean succeed;

    /**
     * 验证结果说明
     */
    private String message;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
