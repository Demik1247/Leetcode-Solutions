class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sc=0,sr=0,er=matrix.length-1,ec=matrix[0].length-1;
List<Integer> ans= new ArrayList<>();

        while(sc<=ec && sr<= er){
                for(int j=sc;j<=ec;j++){
                    ans.add(matrix[sr][j]);
                }

     for(int i=sr+1;i<=er;i++){
                    ans.add(matrix[i][ec]);
                }

     for(int j=ec-1;j>=sc;j--){
        if(sr==er){
            break;
        }
                    ans.add(matrix[er][j]);
                }
                     for(int i=er-1;i>=sr+1;i--){
                        if(sc==ec)break;

                    ans.add(matrix[i][sc]);
                }
                sr++;
                sc++;
                ec--;
                er--;
        }
        return ans;
    }
}