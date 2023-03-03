import java.util.*;
import java.io.*;

public class CitiesAndStates {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("citystate.in"));
        PrintWriter out = new PrintWriter(new File("citystate.out"));

        int n = in.nextInt();
        HashMap<String, Integer> cs = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            String city = in.next().substring(0, 2);
            String state = in.next();
            String key = city + state;
            if (!cs.containsKey(key))
            {
                cs.put(key, 1);
            }
            else
            {
                cs.put(key, cs.get(key) + 1);
            }
        }
        int a = 0;
        for (String key : cs.keySet())
        {
            String okey = key.substring(2) + key.substring(0, 2);
            if (cs.containsKey(okey))
            {
                a += cs.get(key) * cs.get(okey);
            }
        }
        out.println(a/2);
        out.close();
    }
}
