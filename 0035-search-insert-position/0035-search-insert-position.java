class Solution {
    public int searchInsert(int[] nums, int target) {
        int m=nums.length-1;;
        int n=0;
    
while(n<=m){
        int b=(m+n)/2;
        if(nums[b]==target){
            return b;
        }
        else if(nums[b]<target){
            n=b+1;
        }
        else{
            m=b-1;
        }
}
return n;
// n=0;
// m=nums.length-1;
// int c=0;

// while(n<=m){
//  int  b=n+(m-n)/2;
 
//    else if(nums[b]>target){
//         m=b-1;
//         c=b;
//     }

//     else{
//         n=b+1;
//         c=b;
//     }
// }

// return c+1;
    }
} 