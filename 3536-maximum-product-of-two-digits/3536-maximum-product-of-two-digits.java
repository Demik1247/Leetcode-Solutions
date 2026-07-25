class Solution {
    public int maxProduct(int n) {
        String s=String.valueOf(n);
        int[] ar= new int[s.length()];
        int i=0;
          for(char c : s.toCharArray()){
            ar[i++]= c-'0';
          }
          Arrays.sort(ar);
          return ar[ar.length-1]*ar[ar.length-2];
    }
}