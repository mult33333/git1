import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(34,"Ashot");
        hashMap.put(25,"Vzgo");
        hashMap.put(32,"Barigoon");
        System.out.println(hashMap.get(25));
    }
}