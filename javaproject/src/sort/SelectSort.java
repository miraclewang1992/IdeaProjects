package sort;

/**
 * Created by doshest on 2017/7/3.
 */
public class SelectSort {
    public static void  main(String args[]){
        int a[]={49,49,49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        sort(a);
        for (int tmp :a){
            System.out.println(tmp);
        }
    }
    public static void sort(int nums[]){
        for(int i = 0; i<nums.length ; i++){
            int min = nums[i];
            int index =i;
            int temp;
            int k;
            for(k=i+1; k<nums.length;k++){
                if(nums[k]<min){
                    min = nums[k];
                    index =k;

                }
            }
            temp = nums[i];
            nums[i]=min;
            nums[index]=temp;
        }

    }
}
