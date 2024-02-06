import java.util.*;

public class TargetPractice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), c = in.nextInt();
        ArrayList<Integer> targets = new ArrayList<Integer>();
        boolean extraFromFire = false;
        for (int i = 0; i < t; i++)
        {
            targets.add(in.nextInt());
        }
        char[] commands = in.next().toCharArray();
        ArrayList<Integer> shots = new ArrayList<Integer>();

        int pos = 0;
        // go through commands starting at zero; keep track of max and min for extraFromFire
        int min = 0, max = 0;
        for (int i = 0; i < commands.length; i++)
        {
            if (commands[i] == 'L')
                pos--;
            if (commands[i] == 'R')
                pos++;
            if (commands[i] == 'F')
            {
                shots.add(pos);
            }
            min = Math.min(min, pos);
            max = Math.max(max, pos);
            // if there is an undestroyed target between min and max, 
            // the extra for F is 1
        }
        int[] hits0 = new int[shots.size()];
        int[] hits1 = new int[shots.size()];
        int[] hitsn1 = new int[shots.size()];
        int[] hits2 = new int[shots.size()];
        int[] hitsn2 = new int[shots.size()];
        
        boolean[] destroyed = new boolean[(2 * c) + 1];
        for (int i = 0; i < shots.size(); i++)
        {
            if (targets.contains(shots.get(i)) && !destroyed[2 * shots.get(i) + 1])
            {
                hits0[i] = 1;
                destroyed[2 * shots.get(i) + 1] = true;
            }
            else
            {
                hits0[i] = 0;
            }
        }
        
    }

    static int commonality (ArrayList<Integer> a, ArrayList<Integer> b)
    {
        int an = 0;
        for (int i = 0; i < a.size(); i++)
        {
            if (b.contains(a.get(i)))
                an++;
        }
        return an;
    }
}
