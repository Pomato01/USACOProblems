import java.util.*;
import java.io.*;

public class RentalService { //algorithm just wrong :|
    static class Order implements Comparable<Order>
    {
        int p;
        int q;
        public Order (int q, int p)
        {
            this.q = q;
            this.p = p;
        }
        public int compareTo (Order other)
        {
            return other.p - p;
        }
        public int total(){return p*q;}

        @Override
        public String toString()
        {
            return "(" + q + ", " + p + ")";
        }
    }

    static int n, m, r, a;
    static ArrayList<Order> orders;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("rental.in"));
        PrintWriter out = new PrintWriter(new File("rental.out"));
        
        n = in.nextInt();
        m = in.nextInt();
        r = in.nextInt();

        int[] cows = new int[n];
        orders = new ArrayList<>();
        int[] rent = new int[Math.max(r,n)];

        for (int i = 0; i < n; i++)
        {
            cows[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++)
        {
            orders.add(new Order(in.nextInt(), in.nextInt()));
        }
        for (int i = 0; i < r; i++)
        {
            rent[i] = in.nextInt();
        }
        Collections.sort(orders);

        int[] O = new int[n];

        Arrays.sort(rent);
        for (int i = 0; i < rent.length/2; i++)
        {
            int temp = rent[i];
            rent[i] = rent[rent.length - 1 - i];
            rent[rent.length - 1 - i] = temp;
        }
        for (int i = 1; i < rent.length; i++)
        {
            rent[i] += rent[i - 1];
        }
        Arrays.sort(cows);
        for (int i = 0; i < cows.length/2; i++)
        {
            int temp = cows[i];
            cows[i] = cows[cows.length - 1 - i];
            cows[cows.length - 1 - i] = temp;
        }

        O[0] = orderVal(cows[0]);
        for (int i = 1; i < n; i++)
        {
            O[i] = O[i - 1] + orderVal(cows[i]);
        }
        int a = Math.max(rent[rent.length-1], O[O.length-1]);

        for (int i = 1; i < n; i++)
        {
            a = Math.max(a, rent[i - 1] + O[n - 1 - i]);
        }
        // System.out.println(Arrays.toString(rent));
        // System.out.println(Arrays.toString(O));
        // System.out.println(orderVal(13));
        out.println(a);
        out.close();
    }

    static int orderVal(int amt)
    {
        int t = 0;
        while (amt > 0 && orders.size() > 0)
        {
            if (amt >= orders.get(0).q)
            {
                t += orders.get(0).total();
                amt -= orders.get(0).q;
                orders.remove(0);
            }
            else 
            {
                t += amt * orders.get(0).p;
                orders.get(0).q -= amt;
                amt = 0;
            }
        }
        return t;
    }
}
