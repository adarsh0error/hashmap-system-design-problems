import java.util.*;

public class Problem7_AutocompleteSystem {

    private HashMap<String, Integer> queries = new HashMap<>();

    public void addQuery(String query) {
        queries.put(query, queries.getOrDefault(query, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> results = new ArrayList<>();

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix)) {
                results.add(q);
            }
        }

        results.sort((a, b) -> queries.get(b) - queries.get(a));

        return results.subList(0, Math.min(10, results.size()));
    }

    public static void main(String[] args) {

        Problem7_AutocompleteSystem system = new Problem7_AutocompleteSystem();

        system.addQuery("apple");
        system.addQuery("app");
        system.addQuery("application");
        system.addQuery("app");

        System.out.println(system.search("app"));
    }
}