
import java.util.ArrayList;
import java.util.List;

public class Day9 {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        
        int lastAnswer = 0;
        
        for (List<Integer> query : queries) {
            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            
            int index = (x ^ lastAnswer) % n;
            List<Integer> seq = seqList.get(index);
            
            if (type == 1) {
                seq.add(y);
            } else if (type == 2) {
                int size = seq.size();
                lastAnswer = seq.get(y % size);
                result.add(lastAnswer);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> query1 = new ArrayList<>();
        query1.add(1);
        query1.add(0);
        query1.add(5);
        List<Integer> query2 = new ArrayList<>();
        query2.add(1);
        query2.add(1);
        query2.add(7);
        List<Integer> query3 = new ArrayList<>();
        query3.add(1);
        query3.add(0);
        query3.add(3);
        List<Integer> query4 = new ArrayList<>();
        query4.add(2);
        query4.add(1);
        query4.add(0);
        List<Integer> query5 = new ArrayList<>();
        query5.add(2);
        query5.add(1);
        query5.add(1);
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);
        
        List<Integer> result = dynamicArray(n, queries);
        System.out.println(result);
    }
}
