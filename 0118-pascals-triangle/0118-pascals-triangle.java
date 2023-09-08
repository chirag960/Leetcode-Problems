class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        
        for(int i=1;i<=numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = null;
            if(i > 1){
                 prev = answer.get(i-2);
            }
            for(int j=1;j<=i;j++){
                if(j==1 || j==i){
                    row.add(1);
                }
                else{
                    row.add(prev.get(j-1) + prev.get(j-2));
                }
            }
            answer.add(row);
        }
        return answer;
    }
}