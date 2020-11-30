/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

import java.util.*;

public class Sender2<E> extends Thread {
    private MonitorBBuf2<E> buf;
    private List<E> msgs;

    public Sender2(MonitorBBuf2<E> buf, List<E> msgs) {
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
