package sort;

//选择排序
public class SelectSort {

    private static int[] arr = {9,2,8,5,3,4,1,0,7,6};

    public static void main(String[] args) {
        for(int i=0;i<arr.length - 1;i++){
            swap(arr,i,min(i,arr));
        }
    }

    public static int min(int start,int[] arrays){
        int index = start;
        for(int i=start;i<arrays.length;i++){
            if(arrays[index] > arrays[i]) {
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] arrays,int a,int b){
        if(a == b)
            return;
        arrays[a] = arrays[a] + arrays[b];
        arrays[b] = arrays[a] - arrays[b];
        arrays[a] = arrays[a] - arrays[b];
    }
}
