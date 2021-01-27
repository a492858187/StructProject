package sort;

public class MergeSort {

    private static int[] arr = {9,2,8,5,3,4,1,0};
    private static int[] temp = new int[arr.length];

    public static void main(String[] args) {
        //sort(arr,0,arr.length-1);
        sort2(arr);
    }

    //自顶向下
    public static void sort(int[] array,int start,int end){
        if(end <= start)
            return;
        int half = start + (end - start)/2;
        sort(array,start, half);
        sort(array,half+1,end);
        merge(array,start,half,end);
    }

    //自下向顶
    public static void sort2(int[] array){
        int N = array.length;
        for (int i=1;i<N;i=i+i){
            //System.out.println("i为："+i);
            for (int start=0;start<N-i;start+=i+i){
                //System.out.println("start为："+start+",end为："+(N-i));
                merge(array,start,start+i-1,Math.min(start+i+i-1,N-1));
            }
        }
    }

    public static void merge(int[] array,int start,int mid,int end){
        //System.out.println("merge---->start为："+start+",mid为："+mid+",end为："+end);
        int i=start,j=mid+1;
        for(int k=start;k<=end;k++){
            temp[k] = array[k];
        }
        for(int k=start;k<=end;k++){
            if(i>mid)
                array[k] = temp[j++];
            else if(j>end)
                array[k] = temp[i++];
            else if(temp[j] < temp[i])
                array[k] = temp[j++];
            else
                array[k] = temp[i++];
        }
    }

}
