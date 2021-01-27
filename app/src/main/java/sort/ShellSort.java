package sort;

public class ShellSort {

    private static int[] arr = {9,2,8,5,3,4,1,0,7,6,10,12,11};

    public static void main(String[] args) {
        sort1();
    }

    public static void swap(int[] arrays,int a,int b){
        if(a == b)
            return;
        arrays[a] = arrays[a] + arrays[b];
        arrays[b] = arrays[a] - arrays[b];
        arrays[a] = arrays[a] - arrays[b];
    }

    public static void sort1(){
        int N = arr.length;
        int gap = 1;
        while (gap < N/3)
            gap = 3*gap+1;
        while (gap >= 1){
            for (int i=gap;i<N;i++){
                for(int j=i;j>=gap&&arr[j]<arr[j-gap];j-=gap)
                    swap(arr,j,j-gap);
            }
            gap=gap/3;
        }
    }
}
