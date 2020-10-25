public class TestUndo2 {
    public static void main(String[] args) {
        BlueClassUndo2 bou = new BlueClassUndo2();
        bou.put("x",3);
        bou.put("y",4);
        bou.put("x",5);
        System.out.println("x: " + bou.get("x"));
        System.out.println("bou: " + bou);
        bou.undo();
        System.out.println("-- undo --");
        System.out.println("x: " + bou.get("x"));
        System.out.println("bou: " + bou);
        bou.put("z",6);
        System.out.println("bou: " + bou);
        bou.undo();
        System.out.println("bou: " + bou);
    }
}