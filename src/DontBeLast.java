import java.util.*;
import java.io.*;

public class DontBeLast {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("notlast.in"));
        PrintWriter out = new PrintWriter(new File("notlast.out"));
        int n = in.nextInt();
        TreeMap<String, Integer> milk = new TreeMap<>();
        TreeMap<Integer, String> milk2 = new TreeMap<>();

        milk.put("Bessie", 0);
        milk.put("Elsie", 0);
        milk.put("Daisy", 0);
        milk.put("Gertie", 0);
        milk.put("Annabelle", 0);
        milk.put("Maggie", 0);
        milk.put("Henrietta", 0);
        for (int i = 0; i < n; i++)
        {
            String cow = in.next();
            int amount = in.nextInt();
            milk.replace(cow, milk.get(cow) + amount);
        }
        String ckey = "";
        for (int i = 0; i < milk.size(); i++)
        {
            if (i == 0)
                ckey = milk.firstKey();
            else
                ckey = milk.higherKey(ckey);
            milk2.put(milk.get(ckey), ckey);
        }
        int M = milk2.firstKey();
    }
}
