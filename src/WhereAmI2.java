import java.util.*;
import java.io.*;

public class WhereAmI2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("whereami.in"));
        PrintWriter out = new PrintWriter(new File("whereami.out"));
        int a = 0;
        int n = in.nextInt();
        String s = in.next();
        while (duplicates(a, s))
            a++;
        out.println(a);
        out.close();
    }

    public static boolean duplicates (int len, String s)
    {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - len + 1; i++)
        {
            if (set.contains(s.substring(i, i + len)))
                return true;
            set.add(s.substring(i, i + len));
        }
        return false;
    }
}
