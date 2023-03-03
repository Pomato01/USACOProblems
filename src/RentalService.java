import java.util.*;
import java.io.*;

public class RentalService {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("rental.in"));
        PrintWriter out = new PrintWriter(new File("rental.out"));
        int n = in.nextInt(), m = in.nextInt(), r = in.nextInt();
        
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
        {
            c[i] = in.nextInt();
        }
        int[] p = new int[m];
        int[] q = new int[m];
    }
}
