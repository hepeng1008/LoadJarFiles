package testpackage.mapdemo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        Map<String, String> stringStringMap = Collections.synchronizedMap(map);
    }
}
