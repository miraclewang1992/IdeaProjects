package sort;

/**
 * Created by doshest on 2017/7/3.
 */
public class MaoPao {
    public  static  void main(String args[]){
            int nums[] = {1,12,3,6,5,9,2,3,4};
             for(int i=0;i<nums.length-1;i++){
                 for(int j=i+1;j<nums.length;j++){
                        MaoPao.sort(nums,i,j);
                 }
             }
        for (int tmp :nums){
            System.out.println(tmp);
        }

    }
    public static  void sort(int nums[],int i,int j){
        int tmp =nums[i];
        if(nums[i]<nums[j]){
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
}
