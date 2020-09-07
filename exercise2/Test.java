public class Test {
    public static void main(String[] args) {
        BlueClass bo = new BlueClass();
        bo.put("x",3);
        bo.put("y",4);
        bo.put("x",5);
        System.out.println("x: " + bo.get("x"));
        System.out.println("bo: " + bo);
    }
}