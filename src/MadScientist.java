import java.util.*;
import java.io.*;

public class MadScientist {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("breedflip.in"));
        PrintWriter out = new PrintWriter(new File("breedflip.out"));
        int n = in.nextInt();
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int count = 0;
        boolean[] flip = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            flip[i] = a[i] != b[i];
            if (i == 0 && flip[i])
                count++;
            if (i != 0 && flip[i] && !flip[i - 1])
                count++;
        }
        out.println(count);
        out.close();
    }
}
