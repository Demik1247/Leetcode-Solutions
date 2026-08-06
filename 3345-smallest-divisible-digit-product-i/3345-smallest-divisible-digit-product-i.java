class Solution {
    public int smallestNumber(int n, int t) {
        
       for(int i=n; ;i++){
          int  answer=digits(i);
            if(answer%t==0){
              return i;
            }
       }
    
    }

private int digits(int n){
    int dp=1;
    while(n>0){
        int rem=n%10;
        dp= dp*rem;
        n/=10;
    }
    return dp;
}
}