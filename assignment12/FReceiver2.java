/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

import java.util.*;

public class FReceiver2<E> extends Thread {
    private AtomicBBuf<E> buf;
    private List<E> msgs;
    private int nom;

    public FReceiver2(AtomicBBuf<E> buf, List<E> msgs, int nom) {
        this.buf = buf;
        this.msgs = msgs;
        this.nom = nom;
    }

    public void run() {
        for (int i = 0; i < nom; i++) {
            msgs.add(buf.get());
        }
    }
}
