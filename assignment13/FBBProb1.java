/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

import java.util.*;

public class FBBProb1 {
    public static void main(String[] args) throws InterruptedException{
        List<Integer> log = new ArrayList<Integer>();
        FMonitorBBuf1<Integer> buf = new FMonitorBBuf1<Integer>(2, log);
        List<Integer> msgsSent = new ArrayList<Integer>();

        for (int i = 0; i < 2; i++) {
            msgsSent.add(i);
        }

        List<Integer> msgsReceived = new ArrayList<Integer>();
        int nom = msgsSent.size() + msgsSent.size();
        FSender1<Integer> sender1 = new FSender1<Integer>(buf, msgsSent);
        FSender1<Integer> sender2 = new FSender1<Integer>(buf, msgsSent);
        FReceiver1<Integer> receiver = new FReceiver1<Integer>(buf, msgsReceived, nom);

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
