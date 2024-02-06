import java.util.*;
import java.io.*;

// public class LoadBalancing  { // for bronze, add an in.nextInt() after n initialization
//     public static int[] xs;
//     public static int[] ys;
//     public static int n;
//     public static void main(String[] args) throws IOException {
//         Scanner in = new Scanner(new File("balancing.in"));
//         PrintWriter out = new PrintWriter(new File("balancing.out"));
//         n = in.nextInt();
//         xs = new int[n];
//         ys = new int[n];
//         int m = 100;
        
//         for (int i = 0; i < n; i++)
//         {
//             xs[i] = in.nextInt();
//             ys[i] = in.nextInt(); 
//         }
        
//         // for (int i = 0; i < n; i++)
//         // {
//         //     m = Math.min(m, findM(xs[i] + 1, ys[i] + 1));
//         // }
//         // out.println(m);
//         // out.close();

//         // for (int x = 0; x < b; x += 2)
//         // {
//         //     for (int y = 0; y < b; y += 2)
//         //     {
//         //         m = Math.min(m, findM(x, y));
//         //     }
//         // }

//         for (int i = 0; i < n; i++)
//         {
//             for (int j = 0; j < n; j++)
//             {
//                 m = Math.min(m, findM(xs[i] + 1, ys[j] + 1));
//             }
//         }
//         out.println(m);
//         out.close();
//     }

//     public static int findM (int x, int y)
//     {
//         int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
//         for (int i = 0; i < n; i++)
//         {
//             if (xs[i] > x && ys[i] > y)
//                 q1++;
//             else if (xs[i] < x && ys[i] > y)
//                 q2++;
//             else if (xs[i] < x && ys[i] < y)
//                 q3++;
//             else
//                 q4++;
//         }
//         int max = Math.max(q1, Math.max(q2, Math.max(q3, q4)));
//         return max;
//     }
// }
public class LoadBalancing 
{
    
}
