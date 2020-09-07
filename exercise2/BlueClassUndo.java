/**
 * 回答者: 栗林健太郎
 * 学生番号: 2030006
 * 作成日: 2020年9月8日
*/

public class BlueClassUndo extends BlueClass {
    private String prevKey;
    private Integer prevVal;

    public BlueClassUndo() {
        super();
        prevKey = null;
        prevVal = null;
    }

    public void put(String k, int v) {
        prevKey = k;

        if (super.isRegistered(k)) {
            prevVal = super.get(k);
        } else {
            prevVal = null;
        }

        super.put(k, v);
    }

    public void undo() {
        if (prevKey != null) {
            if (prevVal != null) {
                super.put(prevKey, prevVal);
                prevVal = null;
            } else {
                super.delete(prevKey);
            }
            prevKey = null;
        }
    }
}