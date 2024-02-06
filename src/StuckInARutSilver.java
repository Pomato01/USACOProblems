import java.util.*;

public class StuckInARutSilver {
    static class Cow 
    {
        int x, y;
        public Cow(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Cow> E = new ArrayList<>();
        ArrayList<Cow> N = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
        {
            if (in.next().equals("E"))
                E.add(new Cow(in.nextInt(), in.nextInt()));
            else 
                N.add(new Cow(in.nextInt(), in.nextInt()));
        }
        
    }
}
