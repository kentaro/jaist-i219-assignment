/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

import java.util.*;

public class Receiver2<E> extends Thread {
    private MonitorBBuf2<E> buf;
    private List<E> msgs;
    private int nom;

    public Receiver2(MonitorBBuf2<E> buf, List<E> msgs, int nom) {
        this.buf = buf;
        this.msgs = msgs;
        this.nom = nom;
    }

    public void run() {
        for (int i = 0; i < nom; i++) {
            try {
                msgs.add(buf.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
