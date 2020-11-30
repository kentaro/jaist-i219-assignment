/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

import java.util.*;

public class FSender2<E> extends Thread {
    private FMonitorBBuf2<E> buf;
    private List<E> msgs;

    public FSender2(FMonitorBBuf2<E> buf, List<E> msgs) {
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
