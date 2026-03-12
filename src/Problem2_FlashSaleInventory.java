import java.util.*;

public class Problem2_FlashSaleInventory {

    private HashMap<String,Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String productId,int quantity){
        stock.put(productId,quantity);
        waiting.put(productId,new LinkedList<>());
    }

    public synchronized String purchaseItem(String productId,int userId){

        int current = stock.getOrDefault(productId,0);

        if(current > 0){
            stock.put(productId,current-1);
            return "Success. Remaining: "+(current-1);
        }else{
            waiting.get(productId).add(userId);
            return "Added to waiting list";
        }
    }

    public static void main(String[] args) {

        Problem2_FlashSaleInventory sale = new Problem2_FlashSaleInventory();

        sale.addProduct("iphone",100);

        System.out.println(sale.purchaseItem("iphone",1));
    }
}