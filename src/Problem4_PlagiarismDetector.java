import java.util.*;

public class Problem4_PlagiarismDetector {

    HashMap<String, Set<String>> index = new HashMap<>();

    public List<String> ngrams(String text,int n){

        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();

        for(int i=0;i<=words.length-n;i++){

            String gram="";

            for(int j=0;j<n;j++){
                gram+=words[i+j]+" ";
            }

            list.add(gram.trim());
        }

        return list;
    }

    public void addDocument(String id,String text){

        for(String gram : ngrams(text,3)){

            index.putIfAbsent(gram,new HashSet<>());
            index.get(gram).add(id);
        }
    }
}