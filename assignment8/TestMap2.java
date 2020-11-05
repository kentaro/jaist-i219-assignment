public class TestMap2 {
    public static void main(String[] args) {
        MapInterface<String,Integer> map = new ListMap<String,Integer>();
        map.put("y",3);
        map.put("x",4);
        map.put("z",5);
        map.put("x",6);
        System.out.println(map.get("x"));
        System.out.println(map);
    }
}