package sort;

/**
 * Created by doshest on 2017/7/3.
 */
public class FastSort {
    public  static  void main(String args[]){
        int nums[] = {1,12,3,6,5,9,2,3,4};
        // int nums[]={1,2,3,4,5,6};
        FastSort.quickSort(nums,0,nums.length-1);
        for (int tmp :nums){
            System.out.println(tmp);
        }

    }
    public static  void quickSort(int arr[], int _left, int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left <= right){   //待排序的元素至少有两个的情况
            temp = arr[left];  //待排序的第一个元素作为基准元素
            while(left != right){   //从左右两边交替扫描，直到left = right

                while(right > left && arr[right] >= temp)
                    right --;        //从右往左扫描，找到第一个比基准元素小的元素
                arr[left] = arr[right];  //找到这种元素arr[right]后与arr[left]交换

                while(left < right && arr[left] <= temp)
                    left ++;         //从左往右扫描，找到第一个比基准元素大的元素
                arr[right] = arr[left];  //找到这种元素arr[left]后，与arr[right]交换

            }
            arr[left] = temp;    //基准元素归位
            quickSort(arr,_left,left-1);  //对基准元素左边的元素进行递归排序
            quickSort(arr, right+1,_right);  //对基准元素右边的进行递归排序
        }
    }
}
