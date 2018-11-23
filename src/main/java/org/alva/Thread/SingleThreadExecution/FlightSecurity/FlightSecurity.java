package org.alva.Thread.SingleThreadExecution.FlightSecurity;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class FlightSecurity {

    private int count = 0;

    //登机牌
    private String boardingPass = "null";

    //身份证
    private String idCard = "null";

    public void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;

        this.count++;
        check();
    }

    private void check() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("====Exception====" + toString());
        }
    }

    public String toString() {
        return "The " + count + " passengers,boardingPass [" + boardingPass + "],idCard [" + idCard + "]";
    }
}
