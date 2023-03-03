import java.util.*;
public class TwoTables {
    public static void main(String[] args) {
        // could have been done much simpler. overlap from edge placement
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        for (int r = 0; r < x; r++)
        {
            int W = in.nextInt(), H = in.nextInt();
            int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
            int w = in.nextInt(), h = in.nextInt();
            ArrayList<Double> a = new ArrayList<>();
            for (int i = 0; i <= W - (x2 - x1); i++)
            {
                for (int j = 0; j <= H - (y2 - y1); j++)
                {
                    if (!intersect(0, 0, w, h, i, j, i + x2 - x1, j + y2 - y1))
                    {
                        a.add(Math.sqrt(Math.pow((i - x1), 2) + Math.pow((j - y1), 2)));
                    }
                    if (!intersect(0, H - h, w, H, i, j, i + x2 - x1, j + y2 - y1))
                    {
                        a.add(Math.sqrt(Math.pow((i - x1), 2) + Math.pow((j - y1), 2)));
                    }
                    if (!intersect(W - w, 0, W, h, i, j, i + x2 - x1, j + y2 - y1))
                    {
                        a.add(Math.sqrt(Math.pow((i - x1), 2) + Math.pow((j - y1), 2)));
                    }
                    if (!intersect(W - w, H - h, W, H, i, j, i + x2 - x1, j + y2 - y1))
                    {
                        a.add(Math.sqrt(Math.pow((i - x1), 2) + Math.pow((j - y1), 2)));
                    }
                }
            }
            if (a.isEmpty())
                System.out.println("-1");
            else{
                System.out.println(Collections.min(a));
            }
        }
    }
    public static boolean intersect (int blx1, int bly1, int trx1, int try1, int blx2, int bly2, int trx2, int try2)
    {
        return !(blx1 >= trx2 || blx2 >= trx1 || bly1 >= try2 || bly2 >= try1);
    }
}
