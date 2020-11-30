/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

import java.util.*;

public class BBProb2 {
    public static void main(String[] args) throws InterruptedException{
        List<Integer> log = new ArrayList<Integer>();
        MonitorBBuf2<Integer> buf = new MonitorBBuf2<Integer>(2, log);
        List<Integer> msgsSent = new ArrayList<Integer>();

        for (int i = 0; i < 2; i++) {
            msgsSent.add(i);
        }

        List<Integer> msgsReceived = new ArrayList<Integer>();
        int nom = msgsSent.size() + msgsSent.size();
        Sender2<Integer> sender1 = new Sender2<Integer>(buf, msgsSent);
        Sender2<Integer> sender2 = new Sender2<Integer>(buf, msgsSent);
        Receiver2<Integer> receiver = new Receiver2<Integer>(buf, msgsReceived, nom);

        sender1.start();
        sender2.start();
        receiver.start();
        sender1.join();
        sender2.join();
        receiver.join();

        System.out.println("msgsSent: " + msgsSent);
        System.out.println("msgsReceived: " + msgsReceived);

        if (msgsReceived.equals(msgsSent)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }

        assert msgsReceived.equals(log);
    }
}
