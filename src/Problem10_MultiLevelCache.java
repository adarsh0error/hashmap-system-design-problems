import java.util.*;

public class Problem10_MultiLevelCache {

    LinkedHashMap<String, String> L1 = new LinkedHashMap<>(10000, 0.75f, true);
    HashMap<String, String> L2 = new HashMap<>();

    public String getVideo(String id) {

        if (L1.containsKey(id)) {
            return "L1 Cache Hit";
        }

        if (L2.containsKey(id)) {
            L1.put(id, L2.get(id));
            return "L2 Cache Hit - promoted to L1";
        }

        String data = "VideoFromDatabase";

        L2.put(id, data);

        return "Database Hit";
    }

    public static void main(String[] args) {

        Problem10_MultiLevelCache cache = new Problem10_MultiLevelCache();

        System.out.println(cache.getVideo("video1"));
        System.out.println(cache.getVideo("video1"));
    }
}