/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

import java.util.*;

public class Sender<E> extends Thread {
    private MonitorBBuf<E> buf;
    private List<E> msgs;

    public Sender(MonitorBBuf<E> buf, List<E> msgs) {
        this.buf = buf;
        this.msgs = msgs;
    }

    public void run() {
        for (int i = 0; i < msgs.size(); i++) {
            try {
                buf.put(msgs.get(i));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
