package sort;

/**
 * Created by doshest on 2017/6/1.
 */
public class DirectInsert {
    public static  void main(String args[]){
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        sort(a);
        for (int tmp :a){
            System.out.println(tmp);
        }
        /*int tmp =0;
        for(int i = 1;i<a.length;i++){
            int j = i-1;
            tmp= a[i];
            for (;j>=0&&tmp<a[j];j--){
                a[j+1]= a[j];
            }
            a[j+1]=tmp;
            for (int k =0;k<a.length;k++)
                System.out.print(a[k]+",");
            System.out.println();
        }
        for (int k =0;k<a.length;k++)
        System.out.print(a[k]+",");*/
    }

/*   public void insertDirect(){
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int tmp = 0;
        for(int i=1;i<a.length;i++){
            int j=i-1;
            tmp=a[j];
            for(;j>=0&&tmp>;0){}
        }
    }*/
        public static  void sort(int nums[]){
          for(int i =1;i<nums.length;i++){
              if(nums[i]>nums[i-1]){
                  int tmp=nums[i];
                  int j ;
                  for(j =i-1;j>=0&&nums[j]<tmp;j--){
                        nums[j+1]= nums[j];
                  }
                  nums[j+1]=tmp;
              }

          }
        }
}
