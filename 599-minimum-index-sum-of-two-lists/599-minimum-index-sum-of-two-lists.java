class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> index1 = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            index1.put(list1[i], i);
        }
            
        int sum = 0;
        int max = Integer.MAX_VALUE;
        List<String> rests = new ArrayList<>();
            
        for(int i=0;i<list2.length;i++){
            if(index1.containsKey(list2[i])){
                sum = i + index1.get(list2[i]);
                if(sum < max){
                    max = sum;
                    rests = new ArrayList<>();
                    rests.add(list2[i]);
                }else if(sum == max){
                    rests.add(list2[i]);
                }
            }
        }
        
        return rests.toArray(new String[0]);
    }
}