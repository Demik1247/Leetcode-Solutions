class Solution {
  public int singleNumber(int[] nums) {
    
    int ans= single(nums);
    return ans;  
    }
    public int single(int[] a){

        int result =0;
        for(int n: a){
            result ^= n;
        }
        return result;

    }
}