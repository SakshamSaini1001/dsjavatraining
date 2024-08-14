import java.util.ArrayList;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        ArrayList<HashMap<String,Integer>> arrayList = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        System.out.println(map);
        for (String name : map.keySet()) {
            System.out.println(name);
        }
        for(int age : map.values()) {
            System.out.println(age);
        }
        //to access specific value through hashmap
        System.out.println(map.get("A"));
        map.put("A", 5);
        System.out.println(map.get("A"));
    }
}
