/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

import java.util.*;

public class Receiver<E> extends Thread {
    private MonitorBBuf<E> buf;
    private List<E> msgs;
    private int nom;

    public Receiver(MonitorBBuf<E> buf, List<E> msgs, int nom) {
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
