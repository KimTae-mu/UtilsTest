package org.alva.Thread.SingleThreadExecution.FlightSecurity;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class FlightSecurityTest {
    static class Passengers extends Thread {

        //机场安检类
        private final FlightSecurity flightSecurity;

        //旅客的身份证
        private final String idCard;

        //旅客的登机牌
        private final String boardingPass;

        //构造旅客时传入身份证,登机牌以及机场安检类
        public Passengers(FlightSecurity flightSecurity, String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }

        @Override
        public void run() {
            while (true) {
                flightSecurity.pass(boardingPass, idCard);
            }
        }
    }

    public static void main(String[] args) {
        final FlightSecurity flightSecurity = new FlightSecurity();

        new Passengers(flightSecurity,"A12345","AF123456").start();
        new Passengers(flightSecurity,"B12345","BF123456").start();
        new Passengers(flightSecurity,"C12345","CF123456").start();

    }
}

