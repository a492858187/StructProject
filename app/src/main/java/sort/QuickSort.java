package sort;

public class QuickSort {

    private static int[] arr = {9,2,8,5,3,4,1,0,7,6};
    private static int[] arr1 = {9,2,8,5,3,8,3,2,8,2};

    public static void main(String[] args) {
        //sort(arr,0,arr.length-1);
        sort1(arr1,0,arr1.length-1);
    }

    public static void sort(int[] arr,int start,int end){
        int left = start;
        int right = end;
        int base = arr[left];
        while (left < right){
            while (left < right && arr[right] >= base)
                right--;
            if(left < right)
                arr[left++] = arr[right];
            while (left < right && arr[left] <= base)
                left++;
            if(left < right)
                arr[right--] = arr[left];
        }
        arr[left] = base;
        if(left > start)
            sort(arr,start,left-1);
        if(right < end)
            sort(arr,left + 1,end);
    }

    //三向切分的快速排序（解决包含大量重复数据时使用）----三路快排
    public static void sort1(int[] arr,int start, int end){
        if(end <= start) return;
        int left=start, i=start+1, right=end;
        int base = arr[start];
        while (i <= right){
            if(arr[i] < base)
                swap(arr,left++,i++);
            else if(arr[i] > base)
                swap(arr,i,right--);
            else
                i++;
        }
        sort1(arr,start,left-1);
        sort1(arr,right+1,end);
    }

    //三数取中法
    public static void sort2(int[] arr,int start, int end){
        if(start < end){
            dealPivot(arr,start,end);
            int pivot = end - 1;
            int i = start;
            int j = end - 1;
            while (true){
                while (arr[i] < arr[pivot])
                    i++;
                while (arr[j] > arr[pivot])
                    j--;
                if (i < j) {
                    swap(arr,i,j);
                } else {
                    break;
                }
            }
            if(i < end)
                swap(arr,i,end - 1);
            sort2(arr,start,i-1);
            sort2(arr,i+1,end);
        }
    }

    public static void dealPivot(int[] arr,int start,int end){
        int mid = (start + end)/2;
        if(arr[start] > arr[mid])
            swap(arr,start,mid);
        if(arr[mid] > arr[end])
            swap(arr,mid,end);
        if(arr[start] > arr[end])
            swap(arr,start,end);
        swap(arr,mid,end - 1);
    }

    //数组长度小于7（5-15）时使用插入排序，否则使用优化后的快速排序

    //交换两个数
    public static void swap(int[] arrays,int a,int b){
        if(a == b)
            return;
        arrays[a] = arrays[a] + arrays[b];
        arrays[b] = arrays[a] - arrays[b];
        arrays[a] = arrays[a] - arrays[b];
    }
}
