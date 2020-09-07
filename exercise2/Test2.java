public class Test2 {
    public static void main(String[] args) {
        BlueClass2 bo = new BlueClass2();
        bo.put("x",3);
        bo.put("y",4);
        bo.put("x",5);
        System.out.println("x: " + bo.get("x"));
        System.out.println("bo: " + bo);
    }
}