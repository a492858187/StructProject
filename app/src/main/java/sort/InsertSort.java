package sort;

public class InsertSort {
    private static int[] arr = {9,2,8,5,3,4,1,0,7,6};

    public static void main(String[] args) {
        for (int i=0;i<arr.length-1;i++){
            for(int j = i+1;j>0;j--){
                if(arr[i+1] < arr[j]){
                    swap(arr,i+1,j);
                }
            }
        }
        for (int m=0; m<arr.length; m++){
            System.out.println(m+" ");
        }
    }

    public static void swap(int[] arrays,int a,int b){
        if(a == b)
            return;
        arrays[a] = arrays[a] + arrays[b];
        arrays[b] = arrays[a] - arrays[b];
        arrays[a] = arrays[a] - arrays[b];
    }
}
