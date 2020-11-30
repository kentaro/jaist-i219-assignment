/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

import java.util.*;

public class FSender1<E> extends Thread {
    private NonatomicBBuf<E> buf;
    private List<E> msgs;

    public FSender1(NonatomicBBuf<E> buf, List<E> msgs) {
        this.buf = buf;
        this.msgs = msgs;
    }

    public void run() {
        for (int i = 0; i < msgs.size(); i++) {
            buf.put(msgs.get(i));
        }
    }
}
