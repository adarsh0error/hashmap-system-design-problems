import java.util.*;

public class Problem5_WebsiteAnalytics {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> visitors = new HashMap<>();

    public void process(String url,String user){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        visitors.putIfAbsent(url,new HashSet<>());
        visitors.get(url).add(user);
    }

    public void topPages(){

        pageViews.entrySet()
                .stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(10)
                .forEach(System.out::println);
    }
}