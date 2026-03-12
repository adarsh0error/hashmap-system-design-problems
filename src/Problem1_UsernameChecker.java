import java.util.*;

public class Problem1_UsernameChecker {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void registerUser(String username, int id) {
        users.put(username, id);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        for(int i=1;i<=3;i++){
            suggestions.add(username + i);
        }
        return suggestions;
    }

    public static void main(String[] args) {

        Problem1_UsernameChecker system = new Problem1_UsernameChecker();

        system.registerUser("john",1);

        System.out.println(system.checkAvailability("john"));
        System.out.println(system.checkAvailability("jane"));
    }
}