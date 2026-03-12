import java.util.HashMap;

class TokenBucket {
    int tokens;
    int maxTokens;

    TokenBucket(int maxTokens) {
        this.maxTokens = maxTokens;
        this.tokens = maxTokens;
    }
}

public class Problem6_RateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();

    public boolean allowRequest(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(1000));
        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Problem6_RateLimiter limiter = new Problem6_RateLimiter();

        System.out.println(limiter.allowRequest("client1"));
    }
}