import java.util.*;
import java.io.*;

public class SecretCowCode {
    static long len;
    static char[] s;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cowcode.in"));
        PrintWriter out = new PrintWriter(new File("cowcode.out"));
        s = in.next().toCharArray();
        long n = in.nextLong() - 1;
        len = s.length;
        out.println(track(n));
        out.close();
    }
    
    static char track(long a)
    {
        //System.out.print(a + " ");
        if (a < len)
            return s[(int)a];
        double x = Math.ceil(Math.log(a/len + 1)/Math.log(2)) + 1; // a / len is long div
        if (a == len * Math.pow(2, x - 2))
            a = len * (long)(Math.pow(2, x - 1) - 1);
        else
            a--;
        a -= (len * Math.pow(2, x - 2));
        //System.out.print(a + " ");
        //System.out.println((int)x);
        return track(a);
    }
}
