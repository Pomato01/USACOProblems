import java.util.*;
import java.io.*;

public class CircularBarnSilver
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cbarn.in"));
        PrintWriter out = new PrintWriter(new File("cbarn.out"));
        int n = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
            c[i] = in.nextInt();
        ArrayList<Integer> moving = new ArrayList<>();
    }
}

// public class CircularBarnSilver {
//     static int n;
//     static int[] barn;
//     static int a;
//     public static void main(String[] args) throws IOException {
//         Scanner in = new Scanner(new File("cbarn.in"));
//         PrintWriter out = new PrintWriter(new File("cbarn.out"));
//         n = in.nextInt();
//         barn = new int[n];
//         for (int i = 0; i < n; i++)
//         {
//             barn[i] = in.nextInt();
//         }
//         boolean c = true;
//         a = 0;
//         while(c)
//         {
//             c = fill();
//         }
//         out.println(a);
//         out.close();
//     }

//     static boolean fill()
//     {
//         int fs = -1;
//         for (int j = n - 1; j >= 0; j--)
//         {
//             if (barn[j] == 0)
//             {
//                 fs = j;
//                 break;
//             }
//         }
//         if (fs == -1)
//             return false;
//         int le = -1;
//         for (int i = fs; i >= 0; i--)
//         {
//             if (barn[i] != 0)
//             {
//                 le = i;
//                 break;
//             }
//         }
//         if (le == -1)
//         {
//             for (int i = n - 1; i >= 0; i++)
//             {
//                 if (barn[i] != 0)
//                 {
//                     le = i;
//                     break;
//                 }
//             }
//         }
//         barn[le]--;
//         barn[fs]++;
//         if (fs - le < 0)
//             a += Math.pow(fs - le + n, 2);
//         else 
//             a += Math.pow(fs - le, 2);
//         return true;
//     }
// }
