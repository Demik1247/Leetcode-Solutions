class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
       
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));

      
    }
    private void reverse(int[]nums,int left,int right){
        while(left<= right){
            int temp=nums[left];
            nums[left]= nums[right];
            nums[right]= temp;
            left++;
            right--;
        }
    }

}


// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         k %= n;

//         int[] temp = new int[n];

//         for (int i = 0; i < n; i++) {
//             temp[(i + k) % n] = nums[i];
//         }

//         for (int i = 0; i < n; i++) {
//             nums[i] = temp[i];
//         }
//     }
// }