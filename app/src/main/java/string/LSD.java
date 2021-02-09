package string;

public class LSD {
    public static void main(String[] args) {
        String[] arr = {"4PGC938","2IYE230","3CI0720","1ICK750","10HV845","4JZY524","1ICK750",
                        "3CI0720","10HV845","10HV845","2RLA629","2RLA629","3ATW723"};
        sort(arr,7);
    }

    private static void sort(String[] a,int W){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W-1; d>=0 ;d--){
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}
