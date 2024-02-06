import java.util.*;
import java.io.*;

public class MilkPails {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("pails.in"));
        PrintWriter out = new PrintWriter(new File("pails.out"));
        int x = in.nextInt(), y = in.nextInt(), k = in.nextInt(), m = in.nextInt();
        int maxA = (k + 1)/2, maxS = (k - 1)/2;
        ArrayList<Integer> c = new ArrayList<>();
        int temp = Math.max(x, y);
        y = Math.min(x, y);
        x = temp;

        c.add(x); c.add(y); c.add(0);
        if (k > 1)
            c.add(x + y);
        // int pA, pS;
        // pA = m / y;
        // pS = (x - m)/y;
        // if (pA > 0 && pA <= maxA && pA * y > 0 && pA * y < x + y)
        //     c.add(pA * y);
        // if (pA + 1 > 0 && pA + 1 <= maxA && (pA + 1) * y > 0 && (pA + 1) * y < x + y)
        //     c.add((pA + 1) * y);
        // if (pS > 0 && pS <= maxS && x - (pS * y) > 0)
        //     c.add(x - (pS * y));
        // if (pS + 1 > 0 && pS + 1 <= maxS && x - ((pS + 1) * y) > 0)
        //     c.add(x - ((pS + 1) * y));
        for (int i = 0; i < 101; i++)
        {
            if (i <= maxA && i * y < x + y)
                c.add(i * y);
            if (i <= maxS && x - (i * y) > 0)
                c.add(x - (i * y));
        }
        int a = 201;
        for (int ca : c)
        {
            a = Math.min(a, Math.abs(m - ca));
        }
        out.println(a);
        out.close();
    }
}
