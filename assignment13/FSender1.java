/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

import java.util.*;

public class FSender1<E> extends Thread {
    private FMonitorBBuf1<E> buf;
    private List<E> msgs;

    public FSender1(FMonitorBBuf1<E> buf, List<E> msgs) {
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
