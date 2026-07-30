class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int a : nums){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        for(int a : map.keySet()){
            if(map.get(a)> n/2 ){
            ans=a;
            }
        }
        return ans;
    }
}