import java.util.*;
import java.io.*;

public class Leaders {
    static int pairs = 0;
    static char[] line;
    static int[] e;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("leaders.in"));

        n = in.nextInt();
        line = in.next().toCharArray();
        ArrayList<Integer> pAllLeaders = new ArrayList<>();
        e = new int[n];

        for (int i = 0; i < n; i++)
        {
            e[i] = in.nextInt() - 1;
        }
        int fg = 0, fh = 0;
        for (int i = 0; i < n; i++)
        {
            if (line[i] == 'G')
            {
                fg = i;
                break;
            }
        }
        for (int i = 0; i < n; i++)
        {
            if (line[i] == 'H')
            {
                fh = i;
                break;
            }
        }
        int fgend = e[fg], fhend = e[fh];
        boolean add = true;
        for (int i = fgend + 1; i < n; i++)
        {
            if (line[i] == 'G')
            {
                add = false;
                break;
            }
        }
        if (add)
            pAllLeaders.add(fg);
        add = true;
        for (int i = fhend + 1; i < n; i++)
        {
            if (line[i] == 'H')
            {
                add = false;
                break;
            }
        }
        if (add)
            pAllLeaders.add(fh);
        for (int i = 0; i < pAllLeaders.size(); i++)
        {
            addLLeaders(pAllLeaders.get(i));
        }
        System.out.println(pairs);
    }
    
    static void addLLeaders(int pAllLeader)
    {
        char cChar = line[pAllLeader];
        for (int i = 0; i < pAllLeader; i++)
        {
            if (line[i] == cChar)
                continue;
            else if (e[i] >= pAllLeader)
            {
                pairs++;
            }
        }
    }
}
