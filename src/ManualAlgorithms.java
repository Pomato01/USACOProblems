import java.util.*;

public class ManualAlgorithms {
    public static void main(String[] args) {
        int[] test = {5, 60, 700, -81, 10, 2, 300, 8000};
        mergeSort(test, 0, 7);
        System.out.println(Arrays.toString(test));
    }

    public static void mergeSort (int[] a, int start, int end)
    {
        if (start - end == 1)
        {
            if (a[start] > a[end])
                swap(a, start, end);
            return;
        }
        if (start == end)
        {
            return;
        }
        int mid = (start + end)/2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);

        merge(a, start, mid + 1, end);
    }

    public static void merge (int[] a, int b, int c, int d)
    {
        int i = b; 
        int j = c;
        int counter = 0;

        boolean firstLower = a[c - 1] < a[d];
        int[] temp = new int[d - b + 1];

        while (i < c && j <= d && counter < temp.length)
        {
            if (a[i] > a[j])
            {
                temp[counter] = a[j];
                j++;
            }
            else
            {
                temp[counter] = a[i];
                i++;
            }
            counter++;
        }
        if (firstLower && counter < temp.length)
        {
            while (j <= d)
            {
                temp[counter] = a[j];
                j++;
                counter++;
            }
        }
        else if (counter < temp.length)
        {
            while (i <= c && counter < temp.length)
            {
                temp[counter] = a[i];
                i++;
                counter++;
            }
        }
        for (int x = 0; x < temp.length; x++)
        {
            a[b + x] = temp[x];
        }
        
    }

    public static void swap (int[] a, int x, int y)
    {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
